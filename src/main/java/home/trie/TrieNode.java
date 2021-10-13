package home.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<String, TrieNode> children;

	boolean isEndOfWord;

	String nodeKey;

	public TrieNode(String nodeKey) {
		this.children = new HashMap<>();
		this.isEndOfWord = false;
		this.nodeKey = nodeKey;
	}

}
