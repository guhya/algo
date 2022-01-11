package net.guhya.algo.trie;

public class TheTrie {
	
	public TrieNode root;
	public static int MAX_ALPHABET = 26;
	
	public static class TrieNode {
		boolean isEnd = false;
		TrieNode[] children = new TrieNode[MAX_ALPHABET];
		
		public TrieNode() {
			this.isEnd = false;
			for (int i=0; i<MAX_ALPHABET; i++) {
				this.children[i] = null;
			}
		}
	}
	
	public TheTrie() {
		this.root = new TrieNode();
	}

	public void insert(TrieNode root, String str) {
		if (str == null) return;
		
		int len = str.length();
		if (len == 0) {
			root.isEnd = true;
			return;
		}
		
		int c = str.charAt(0) - 'a';
		if (root.children[c] == null) {
			root.children[c] = new TrieNode();
		}
		
		insert(root.children[c], str.substring(1));
	}
	
	public void traverse(TrieNode root, String tmp) {
		for (int i=0; i<MAX_ALPHABET; i++) {
			if (root.children[i] != null) {
				char c = (char) ('a' + i);
				String p = tmp + c;
				if (root.children[i].isEnd) {
					System.out.println(p);
				}
				traverse(root.children[i], p);
			}
		}
	}
	
	public boolean search(TrieNode root, String key) {
		if (key == null) return false;
		
		int len = key.length();
		if (len == 0) {
			return root.isEnd;
		}
		
		int c = key.charAt(0) - 'a';
		if (root.children[c] != null) {
			return search(root.children[c], key.substring(1));
		} else {
			return false;
		}
	}
	
	public boolean search(String key) {
		return search(this.root, key);
	}
	
	public void printAll() {
		traverse(this.root, "");
	}
	
	public void suggest(TrieNode root, String keyword) {
		if (keyword == null) return;
		
		int len = keyword.length();
		if (len == 0) {
			traverse(root, keyword);
			return;
		} 
		
		int c = keyword.charAt(0) - 'a';
		if (root.children[c] != null) {
			suggest(root.children[c], keyword.substring(1));
		}
	}
	
	public void suggest(String keyword) {
		if ("".equals(keyword)) return;
		
		suggest(this.root, keyword);
	}
	
	public static String findLongest(TrieNode root, String str, String tmp, String result) {
		if (str == null) return "";
		
		int len = str.length();
		if (len == 0) {
			return result;
		}
		
		int c = str.charAt(0) - 'a';
		if (root.children[c] == null) {
			return result;
		}
		
		if (root.children[c].isEnd) {
			return findLongest(root.children[c], str.substring(1), tmp + str.charAt(0), tmp + str.charAt(0));
		} else {
			return findLongest(root.children[c], str.substring(1), tmp + str.charAt(0), result);
		}
		
	}
	
	
	public static void main(String[] args) {
		TheTrie trie = new TheTrie();
		trie.insert(trie.root, "p");
		trie.insert(trie.root, "pandemic");
		trie.insert(trie.root, "panda");
		trie.insert(trie.root, "panorama");
		trie.insert(trie.root, "spain");
		trie.insert(trie.root, "spark");
		trie.insert(trie.root, "sparkling");
		trie.insert(trie.root, "span");
		trie.insert(trie.root, "spandex");
		trie.insert(trie.root, "spandexios");
		trie.insert(trie.root, "spaniard");
		trie.insert(trie.root, "spanish");
		
		trie.printAll();
		System.out.println("++++++++++++++");
		System.out.println(trie.search("spandex"));
		
		System.out.println("++++++++++++++");
		trie.suggest("pand");
		System.out.println("++++++++++++++");
		
		String word = "spanderaxionosaurus";
		System.out.println(findLongest(trie.root, word, "", ""));
		
	}

}
