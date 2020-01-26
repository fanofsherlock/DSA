package Synchronization;

public class Synchronization {

	// to make static data thread-safe, you use class level Synchronisation
	// to make instance level date thread-safe, you use object level Synchornization
	

	private static Object lock1 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new printMyName());
		t1.setName("Thread1");
		t1.setUncaughtExceptionHandler(new ExceptionalHandler());

		Thread t2 = new Thread(new printMyName());
		t2.setName("Thread2");
		t2.setUncaughtExceptionHandler(new ExceptionalHandler());

		t1.start();
		t2.start();
	}

	static class printMyName implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " is executing!");
				try {
					printHisName();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static void printHisName() throws InterruptedException {

		synchronized (lock1) {
			System.out.println(Thread.currentThread().getName() + " has the lock!");
			Thread.currentThread().wait();  
			//This will cause the thread to wait with the lock until it is notified. 
			System.out.println(Thread.currentThread().getName() + " exiting the lock!");
			System.out.println();
		}

	}

}
