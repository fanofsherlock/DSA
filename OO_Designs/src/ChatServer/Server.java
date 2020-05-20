package ChatServer;

import java.util.HashSet;

public class Server {

	HashSet<Client> activeConnections;

	public Server() {
		activeConnections = new HashSet<Client>();
	}

	boolean sendMessage(String msg) {
		return false;
	}

	public boolean sendMessagge(String message, long phoneNo) {
		return false;
	}

	public void addConnection(Client client) {
		activeConnections.add(client);

	}

	public int getActiveConnections() {
		return activeConnections.size();
	}

}
