package MicroserviceAuthentication;

import java.util.HashMap;

public class CentralMicroservice {

	
	private static CentralMicroservice instance;
	
	private HashMap<String, String> accesses;
	private static Object lock = new Object();

	private CentralMicroservice() {
		initAcessMap();
	}

	private void initAcessMap() {
		accesses = new HashMap<String, String>();
		accesses.put("micro1", "token1");
		accesses.put("micro2", "token2");
		accesses.put("micro3", "token3");

	}

	private synchronized boolean authenticateToken(String microServiceName, String token) {
		
		
		if (accesses.containsKey(microServiceName)) {
			return accesses.get(microServiceName).equals(token);
		}

		return false;
	}
	
	
	public static CentralMicroservice getCentralMicroserviceInstance() {
		
		if(instance==null) {
			
			synchronized(CentralMicroservice.class) {
				if(instance==null) {
					instance = new CentralMicroservice();
				}
			}
			
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		cretaeCentralInstance r1 = new cretaeCentralInstance();
		cretaeCentralInstance r2 = new cretaeCentralInstance();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(r1.getObj()==r2.getObj());
	}
	
	
	static class cretaeCentralInstance implements Runnable{
		CentralMicroservice obj;
		
		@Override
		public void run() {
		obj= CentralMicroservice.getCentralMicroserviceInstance();
			
		}
		
       public CentralMicroservice getObj() {
    	   return obj;
       }
		
	}
	
	

}
