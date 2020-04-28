package structual.bridgeAndadapter;

public class BridgeTest {

	public static void main(String[] args) {

		AppServer app = new AppServer();
		WebServer web = new WebServer();

		CLIClient cli = new CLIClient();
		BrowserClient browser = new BrowserClient();

		cli.connectToServer(app);
		cli.connectToServer(web);
		
		browser.connectToServer(web);
		browser.connectToServer(app);
	}
}


