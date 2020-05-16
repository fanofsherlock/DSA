package ChatServer;

import java.util.List;

public class Client1 {
	List<String> chatLogs;
	Server s;

	public Client1(Server s) {
		this.s = s;
		s.registerClient("Client1", this);
	}

}
