package structual.bridgeAndadapter;

public class CLIClient implements Client {

	@Override
	public void connectToServer(Server s) {
		s.returnResult();
	}
}


