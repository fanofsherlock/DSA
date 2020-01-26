package DataStructure;

public class BlockingQueue<T> {

	private T[] queue;
	private int limit = 10;
	int head = 0, tail = 0, size = 0;

	public BlockingQueue(int limit) {
		this.limit = limit;
		this.queue = (T[]) new Object[limit];
	}

	public void enqueue(T item) throws InterruptedException {

		synchronized (queue) {

			while (size == limit) {
				wait();
			}

			queue[++tail] = item;
			size++;
			// Notify other threads which were waiting for Dequeuing
			if (size == 1) {
				notifyAll();
			}
		}
	}

	public Object dequeue() throws InterruptedException {

		synchronized (queue) {

			while (size == 0) {
				wait();
			}

			T item = queue[head];
			head++;
			size--;

			// Notify threads waiting for Enqueuing
			if (size == limit) {
				notifyAll();
			}
			return item;
		}
	}

	
	
	
}