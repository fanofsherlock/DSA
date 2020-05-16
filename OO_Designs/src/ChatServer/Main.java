package ChatServer;

public class Main {

	public static void main(String[] args) {
		Server s = new Server();
		Client c1 = new Client1(s);
		Client c2 = new Client2(s);
		c1.send();
		
	}

}
