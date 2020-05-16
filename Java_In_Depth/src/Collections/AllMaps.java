package Collections;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class AllMaps {
	enum mapEnum {
		ins5, ins4, ins3;
	}

	public static void main(String[] args) {
		TestEnumMap();
		TestHashMap();
		TestTreeMap();
		TestConcurrentHashMap();
		TestConcurrentSkipListMap();
		TestNavMap();
		TestIdentityMap();
		TestWeakHashMAp();

	}

	private static void TestEnumMap() {
		
		EnumMap<mapEnum, Integer> map = new EnumMap<AllMaps.mapEnum, Integer>(mapEnum.class);
		map.put(mapEnum.ins3, 3);
		map.put(mapEnum.ins4, 4);
		map.put(mapEnum.ins5, 5);

		map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "" + e.getValue()));
	}

	// A concurrent Sorted Map (All sorted collections always implement a navigable
	// interface
	private static void TestConcurrentSkipListMap() {
		ConcurrentSkipListMap<String, String> skipMap = new ConcurrentSkipListMap<String, String>(
				(a, b) -> a.compareTo(b));
		skipMap.put("", "");
		skipMap.forEach((k, v) -> System.out.println(k));

	}

	private static void TestTreeMap() {
		TreeMap<String, String> tMap = new TreeMap<String, String>((a, b) -> a.compareTo(b));
		tMap.put("", "");

	}

	private static void TestConcurrentHashMap() {
		ConcurrentHashMap<String, String> cMap = new ConcurrentHashMap<String, String>();
		cMap.put("", "");

	}

	private static void TestWeakHashMAp() {
		WeakHashMap<String, String> wMap = new WeakHashMap<String, String>();
		wMap.put("a", "A");

	}

	private static void TestIdentityMap() {
		IdentityHashMap<String, String> iMap = new IdentityHashMap<String, String>();
		iMap.put("", "");

	}

	public static void TestHashMap() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.compute(String.valueOf(1), (k, v) -> {
			if (v == null) {
				return 1;
			} else {
				return v + 1;
			}
		});

		map.computeIfAbsent("1", k -> 1);
		map.computeIfPresent("1", (k, v) -> v + 1);

		map.putIfAbsent("",

				1);

		map.getOrDefault("", 0);
		map.replaceAll((key, value) -> value);
		Map<String, Integer> map2 = Collections.synchronizedMap(map);
		map2.put("", 1);
	}

	// Navigable Map =Just Like Deque interface
	// TreeMap implements this Navigable Map
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
