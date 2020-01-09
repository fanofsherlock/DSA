package Singleton;



//Broken Singleton 
public class BrokenLazy {

	private static BrokenLazy brokenInstance;
	
	private BrokenLazy() {
	}
	
	public static BrokenLazy getInstance() {
		
		if(brokenInstance==null) {
			brokenInstance=new BrokenLazy();
		}
		
		return brokenInstance;
	}
}

