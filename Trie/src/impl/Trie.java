package impl;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public int getIndex(char x) {
		return x - 'a';
	}

	public boolean insert(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return false;
		}

		key = key.toLowerCase();
		TrieNode current = root;
		int index = -1;
		for (int i = 0; i < key.length(); i++) {
			index = this.getIndex(key.charAt(i));

			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			// this ensures we are at the last inserted
			// character reference at the end of each loop
			current = current.children[index];

		}
		// to signal end of work down this path
		current.markAsLeaf();
		return true;
	}

	public boolean search(String key) {
		if (key == null || key.isEmpty() || key.isBlank()) {
			return false;
		}

		key = key.toLowerCase();
		TrieNode current = root;
		int index = -1;

		for (int i = 0; i < key.length(); i++) {
			index = this.getIndex(key.charAt(i));
			if (current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}

		return true;
	}

}
