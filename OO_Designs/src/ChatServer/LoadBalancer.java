package ChatServer;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class LoadBalancer {

	ConcurrentHashMap<Client, Server> clientServerLookup;
	ConcurrentHashMap<Server, List<Client>> serverClientsLookup;
	PriorityBlockingQueue<Server> serverLoadBalancer;
	Comparator<Server> lessConnectionsFirst = (a, b) -> a.getActiveConnections() - b.getActiveConnections();

	public LoadBalancer(int capacity) {
		serverLoadBalancer = new PriorityBlockingQueue<Server>(capacity, lessConnectionsFirst);
	}

	Server establishContact(Client client) {
		Server s = serverLoadBalancer.poll();
		s.addConnection(client);
		serverLoadBalancer.add(s);
		return s;
	}

}
