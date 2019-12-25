package impl;

public class TrieNode {

	TrieNode[] children;
	Boolean isEndWord;

	public TrieNode() {
		children = new TrieNode[26];
		isEndWord = false;
	}

	void markAsLeaf() {
		isEndWord = true;
	}

	void unMarkAsLeaf() {
		isEndWord = false;
	}

}
