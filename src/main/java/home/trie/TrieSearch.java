package home.trie;

import java.util.function.BiFunction;

public class TrieSearch {

	static BiFunction<TrieNode, String, Boolean> search = (TrieNode trieNode, String word) -> search(trieNode, word);

	private static boolean search(TrieNode trieNode, String word) {
		TrieNode root = trieNode;
		for (int i = 0; i < word.length(); i++) {
			String key = String.valueOf(word.charAt(i));
			if (null == root.children.get(key)) {
				return false;
			}
			root = root.children.get(key);
		}
		return null != root && root.isEndOfWord;
	}

}
