package structual.bridgeAndadapter;

public class BrowserClient implements Client {

	@Override
	public void connectToServer(Server s) {
       s.returnResult();
	}
}



