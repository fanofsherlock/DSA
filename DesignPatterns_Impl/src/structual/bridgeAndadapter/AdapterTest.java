package structual.bridgeAndadapter;

public class AdapterTest {

	public static void main(String[] args) {
		OldBrowserClient browser = new OldBrowserClient();
		browser.connectToServer(new WebServerAdapter(new AppServer()));
	}

}


