package MicroserviceAuthentication;

import java.util.concurrent.atomic.AtomicLong;

public class QuolumWebServer {

	AtomicLong hitCounter;

	public QuolumWebServer() {
		hitCounter = new AtomicLong(0L);
	}

	void inc() {
		hitCounter.incrementAndGet();
	}

	Long getRequestsProcessed() {
		return hitCounter.get();
	}

	public static void main(String[] args) {
		QuolumWebServer webServer = new QuolumWebServer();
		client r1 = new client(webServer);
		client r2 = new client(webServer);
		
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
		
		System.out.println(webServer.getRequestsProcessed());

	}

	static class client implements Runnable {
		private QuolumWebServer server;

		public client(QuolumWebServer server) {
			this.server = server;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				server.inc();
			}
		}

	}

}
