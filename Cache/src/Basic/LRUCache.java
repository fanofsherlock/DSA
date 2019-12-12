package Basic;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	Deque<Integer> dq;
	HashSet<Integer> map;
	final int cacheSize;

	public LRUCache(int cacheSize) {
		dq=new LinkedList<Integer>();
		map=new HashSet<Integer>();
		this.cacheSize = cacheSize;
	}

	private void display() {
		Iterator<Integer> i = dq.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}

	void refer(int x) {
		if (!map.contains(x)) {
			if (dq.size() == cacheSize) {
				int last = dq.removeLast();
				map.remove(last);
			}
		} else {
			dq.remove(x);

		}

		dq.add(x);
		map.add(x);
	}

}
