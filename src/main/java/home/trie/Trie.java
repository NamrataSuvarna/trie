package home.trie;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Trie {

	public static void describeTrieNode(TrieNode trieNode) {
		trieNode.children.entrySet().stream().filter(Objects::nonNull).forEach(e -> {
			System.out.println(e.getKey());
			describeTrieNode(e.getValue());
		});
	}

	public static void main(String[] args) {
		TrieNode trieNode = new TrieNode("");
		Scanner scanner = new Scanner(System.in);
		performTrieOperation(trieNode, scanner, "insert", TrieInsert.insert);
		performTrieOperation(trieNode, scanner, "search", TrieSearch.search);
		performTrieOperation(trieNode, scanner, "delete", TrieDelete.delete);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void performTrieOperation(TrieNode trieNode, Scanner scanner, String operation,
			BiFunction biFunction) {
		System.out.print(String.format("Enter the number of words you want to %s: ", operation));
		int numberOfWords = scanner.nextInt();
		IntStream.range(0, numberOfWords).boxed().map(i -> scanner.next()).forEach(
				e -> System.out.println(String.format("%s %s -> %s", operation, e, biFunction.apply(trieNode, e))));
		describeTrieNode(trieNode);
	}

}
