package ReferenceTypes;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SoftReferenceCache {

	private HashMap<Integer, SoftReference<String>> cache;

	public SoftReferenceCache() {
		cache = new HashMap<>();
	}

	public void store(int key, String value) {
		cache.putIfAbsent(key, new SoftReference<String>(value));
	}

	public String get(int key) {
		String val = cache.get(key).get();
		return val == null ? "" : val;

	}

	public static void main(String[] args) {
		SoftReferenceCache sc = new SoftReferenceCache();
		sc.store(97, "a");
		sc.store(98, "b");
		sc.store(99, "c");
		System.out.println(sc.get(97));
		WeakHashMap<String, Integer> wMap = new WeakHashMap<String, Integer>();
	}

}
