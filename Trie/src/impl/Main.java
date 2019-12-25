package impl;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		String output[] = { "Not present in trie", "Present in trie" };
		
		Trie t = new Trie();

		System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			t.insert2(keys[i]);
			System.out.println("\"" + keys[i] + "\"" + "Inserted.");
		}
		
		System.out.println("\n");
		System.out.println(t.search("the")?output[1]:output[0]);
		System.out.println(t.search("abc")?output[1]:output[0]);
		System.out.println(t.search("zarathustra")?output[1]:output[0]);
	}

}
