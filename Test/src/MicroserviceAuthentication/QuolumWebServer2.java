package MicroserviceAuthentication;

public class QuolumWebServer2 {

	int[] hits;
	long[] times;

	public QuolumWebServer2() {
		hits = new int[60];
		times = new long[60];
	}

	public synchronized void inc(long time) {
		int index = (int) time % 60;

		if (times[index] < time) {
			times[index] = time;
			hits[index] = 0;
		}

		hits[index]++;

	}

	public synchronized Long count(Long time) {
		Long count = 0L;

		for (int i = 0; i <60; i++) {
			if (time - times[i] <= 60) {
				count+=hits[i];
			}
		}

		return count;
	}

	static class Client1 implements Runnable {
		private QuolumWebServer2 server;

		public Client1(QuolumWebServer2 server) {
			this.server = server;
		}

		@Override
		public void run() {
			for (int i = 0; i < 60; i++) {
				server.inc(i);
				server.inc(i);
			}
		}

	}
	
	
	static class Client2 implements Runnable { 
		private QuolumWebServer2 server;

		public Client2(QuolumWebServer2 server) {
			this.server = server;
		}

		@Override
		public void run() {
			for (int i = 60; i < 120; i+=5) {
				server.inc(i);
				server.inc(i);
			}
		}

	}
	
	

	public static void main(String[] args) throws InterruptedException {
		QuolumWebServer2 server2 = new QuolumWebServer2();
		Client1 c1 = new Client1(server2);
		Client2 c2 = new Client2(server2);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		
		System.out.println(server2.count(120L));
		

	}

}
