package ChatServer;

import java.util.HashMap;

public class Server {
	HashMap<String, Client> clients;

	public Server() {
		clients = new HashMap<String, Client>();
	}

	void registerClient(String clientName, Client client) {
		clients.put(clientName, client);
	}

	void recieveMessage(String msg, String clientName) {
		Client client = clients.get(clientName);
		if (client != null) {
			client.receive(msg);
		}
	}

	public boolean sendMessagge(String message, long phoneNo) {
		return false;
	}

}
