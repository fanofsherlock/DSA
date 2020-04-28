package creational.singleton;

public class BillPough {

	public BillPough(String x) {
	}

	private BillPough() {
	}

	private static class BillPoughSingleton {
		private static final BillPough instance = new BillPough();

	}

	public static BillPough getInstance() {
		return BillPoughSingleton.instance;
	}

}
