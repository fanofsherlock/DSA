package Singleton;

public class GoodEager {
	
	private static GoodEager eager;
	
	static {
		
		try {
			eager = new GoodEager();
		} catch(Exception e){
		}
	}

	private GoodEager() {
	}
}
