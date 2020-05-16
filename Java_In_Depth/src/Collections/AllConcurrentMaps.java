package Collections;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class AllConcurrentMaps {

	public static void main(String[] args) {
		TestConcurMaps();
	}

	private static void TestConcurMaps() {

		// Concurrent Navigable Map implementation that gives logN for each operation
		ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);

		// Concurrent Navigable Set
		ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>();
		set.add(21);

		CopyOnWriteArraySet<Integer> set2 = new CopyOnWriteArraySet<Integer>();

	}

}
