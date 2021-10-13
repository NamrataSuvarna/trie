package home.trie;

import java.util.function.BiFunction;

public class TrieDelete {

	static BiFunction<TrieNode, String, TrieNode> delete = (TrieNode trieNode, String word) -> delete(trieNode, word);

	private static TrieNode delete(TrieNode trieNode, String word) {
		TrieNode parentNode = null;
		int nodeDepth = word.length();
		String nodeKey = null;
		while (nodeDepth >= 0) {
			parentNode = getTrieNode(trieNode, word, nodeDepth, 0);
			if (null == parentNode) {
				return null;
			}
			if (null != nodeKey) {
				parentNode.children.remove(nodeKey);
			}
			if (nodeDepth == word.length() && !parentNode.children.isEmpty()) {
				parentNode.isEndOfWord = false;
				return parentNode;
			}
			nodeKey = parentNode.children.isEmpty() ? parentNode.nodeKey : null;
			nodeDepth--;
		}
		return parentNode;
	}

	private static TrieNode getTrieNode(TrieNode trieNode, String word, int nodeDepth, int trieDepth) {
		if (trieDepth == nodeDepth) {
			return trieNode;
		}
		if (null == trieNode) {
			return null;
		}
		return getTrieNode(trieNode.children.get(String.valueOf(word.charAt(trieDepth))), word, nodeDepth,
				trieDepth + 1);
	}

}
