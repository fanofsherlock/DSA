package Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class AllMaps {

	public static void main(String[] args) {
		TestHashMap();
		TestNavMap();
	}

	public static void TestHashMap() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		Integer[] ints = new Integer[] { 1, 2, 3, 1, 1, 3 };

		for (Integer i : ints) {
			map.compute(String.valueOf(i), (k, v) -> {
				if (v == null) {
					return 1;
				} else {
					return v + 1;
				}
			});
		}

		Map<String, Integer> map2 = Collections.synchronizedMap(map);
		map2.put("", 1);

	}

	public static void TestNavMap() {
		NavigableMap<String, Integer> map = new TreeMap<String, Integer>((s1, s2) -> s1.compareTo(s2));
		map.put("a", 1);
		map.put("b", 1);
		map.put("abc", 1);
		map.put("abc", 1);
		map.put("abcd", 2);
		printMap(map);

		NavigableMap<String, Integer> map2 = map.descendingMap();
		// From that value to the head of the map, or the first value
		NavigableMap<String, Integer> map3 = map.headMap("abc", true);
		NavigableMap<String, Integer> map4 = map.tailMap("abc", true);

		printMap(map2);
		printMap(map3);
		printMap(map4);

		// Other methods
		map.ceilingEntry("abc");
		map.ceilingKey("abc");
		map.firstEntry();
		map.firstKey();
		map.subMap("a", "abc");
	}

	public static <K, V> void printMap(Map<K, V> map) {
		for (Entry<K, V> e : map.entrySet()) {
			System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
		}
		System.out.println("\n");
	}

}
