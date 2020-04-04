package DataStructure;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueLocks<T> {
	private T[] backingArray;
	private int capacity;
	int size=0;
	int head=0,tail=0;
	private Lock lock = new ReentrantLock();
	private Condition enQCondition = lock.newCondition();
	private Condition dQCondition = lock.newCondition();

	public BlockingQueueLocks(int capacity) {
		this.capacity = capacity;
		backingArray = (T[]) new Object[capacity];
	}

	public void enQ(T data) {
          lock.lock();
          while(size==capacity) {
        	  lock.unlock();
        	  lock.lock();
          }
		
          if(tail==capacity) {
        	  tail=0;
          }
          
          backingArray[tail++]=data;
          dQCondition.signalAll();
          
          size++;
          lock.unlock();
		
	}
	
	public T dQ() {
		lock.lock();
		
		while(size==0) {
			lock.unlock();
			lock.lock();
		}
		
		if(head==capacity) {
			head=0;
		}
		
		T data = backingArray[head++];
		
		size--;
		lock.unlock();
		
		return data;
		
	}

	
}
