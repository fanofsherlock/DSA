package structual.bridgeAndadapter;

public class WebServerAdapter extends WebServer {
	private Server server;

	public WebServerAdapter(Server server) {
		this.server = server;
	}

	@Override
	public void returnResult() {
		server.returnResult();
	}
}


