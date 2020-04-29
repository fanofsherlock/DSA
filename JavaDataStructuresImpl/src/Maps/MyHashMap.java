package Maps;

public class MyHashMap<K, V> {

	/*
	 * Why is Entry class static?
	 * 
	 * Non-static inner classes have an extra, hidden field that points to the
	 * instance of the outer class. So if the Entry class weren't static 1) then
	 * besides having access that it doesn't need 2) it would carry around four
	 * pointers instead of three
	 * 
	 */

	static class Entry<K, V> {
		
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		void setNext(Entry<K, V> next) {
			this.next = next;
		}

	}

	private Entry[] entryTable;
	int elementsFilled = 0;
	float loadFactor = 0.75f;

	public MyHashMap(int initCapacity) {
		entryTable = new Entry[initCapacity];
	}

	private void resize() {
	
		if (elementsFilled >= loadFactor * entryTable.length) {
			
			Entry[] newEntryTable = new Entry[entryTable.length * 2];
			for (int i = 0; i < entryTable.length; i++) {
				newEntryTable[i] = entryTable[i];
			}

			System.out.println("Resizing done from " + entryTable.length + " to " + newEntryTable.length + " elements");
			entryTable = newEntryTable;

		}
	}

	public void put(K key, V value) {
		resize();
		int hash = key.hashCode() % entryTable.length;
		Entry head = entryTable[hash];

		if (head == null) {
			entryTable[hash] = new Entry<K, V>(key, value);
			elementsFilled++;
			return;
		}

		Entry prev = head;

		while (head != null) {

			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			prev = head;
			head = head.next;
		}

		prev.next = new Entry<K, V>(key, value);
		elementsFilled++;
	}

	public V get(K key) {
		V result = null;

		int hash = key.hashCode() % entryTable.length;

		Entry<K, V> head = entryTable[hash];
		Entry<K, V> prev = head;

		while (head != null) {

			if (head.key.equals(key)) {
				result = head.value;
				break;
			}

			prev = head;
			head = head.next;
		}
		return result;
	}

	public void remove(K key) {
		int hash = key.hashCode() % entryTable.length;

		Entry<K, V> head = entryTable[hash];
		Entry<K, V> dummy = new Entry<K, V>(null, null);
		dummy.next = head;
		Entry<K, V> prev = dummy;

		while (head != null) {

			if (head.key.equals(key)) {
				prev.next = head.next;
				elementsFilled--;
				break;
			}
			prev = head;
			head = head.next;
		}

		entryTable[hash] = dummy.next;

	}

	public boolean containsKey(K key) {
		int hash = key.hashCode() % entryTable.length;
		Entry<K, V> head = entryTable[hash];
		Entry<K, V> prev = head;

		while (head != null) {

			if (head.key.equals(key)) {
				return true;
			}
			prev = head;
			head = head.next;
		}

		return false;

	}

	public int size() {
		return elementsFilled;
	}

}
