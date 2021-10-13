package home.trie;

import java.util.function.BiFunction;

public class TrieInsert {

	static BiFunction<TrieNode, String, Boolean> insert = (TrieNode trieNode, String word) -> insert(trieNode, word);

	private static boolean insert(TrieNode trieNode, String word) {
		TrieNode root = trieNode;
		for (int i = 0; i < word.length(); i++) {
			String key = String.valueOf(word.charAt(i));
			if (null == root.children.get(key)) {
				root.children.put(key, new TrieNode(key));
			}
			root = root.children.get(key);
		}
		root.isEndOfWord = true;
		return true;
	}

}
