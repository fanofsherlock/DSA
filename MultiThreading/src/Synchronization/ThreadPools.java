package Synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(()->System.out.print("Sample Thread"), "");
	}
}
