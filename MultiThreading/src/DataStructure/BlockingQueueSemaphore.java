package DataStructure;

import java.util.concurrent.Semaphore;

public class BlockingQueueSemaphore<T> {

	private T[] backingArray;
	private int capacity;
	private int size = 0;
	private int head = 0, tail = 0;

	private Semaphore prodSemaphore;
	private Semaphore conSemaphore;

	public BlockingQueueSemaphore(int capacity, int permits) {
		prodSemaphore = new Semaphore(permits);
		conSemaphore = new Semaphore(permits);
	}

	public void enQ(T data) {

		try {
			prodSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conSemaphore.release();
		}

	}
}
