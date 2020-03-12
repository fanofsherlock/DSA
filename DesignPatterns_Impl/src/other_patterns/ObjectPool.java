package other_patterns;

import java.util.concurrent.ConcurrentHashMap;

public class ObjectPool<T> {
	ConcurrentHashMap<T, T> map = new ConcurrentHashMap<T, T>();

	T get(T Object) {
		T old = map.putIfAbsent(Object, Object);
		return old == null ? Object : old;
	}

	
	public static void main(String[] args) {
		ObjectPool<String> stringPool = new ObjectPool<String>();
		String s = stringPool.get("abc");
		String s2 = stringPool.get("abc");
		
		//Checking the actual underneath object
		if (s == s2) {
			System.out.println(true);
		}
	}
}
