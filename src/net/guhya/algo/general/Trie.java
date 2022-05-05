package net.guhya.algo.general;

public class Trie {

	class Node {
		Node[] children;
		boolean isEnd;
		
		public Node() {
			children = new Node[26];
			isEnd = false;
		}
	}

	Node root;
	
    public Trie() {
    	root = new Node();
    }
    
    public void insert(String word) {
    	insert(word, root, 0);
    }
    
    private void insert(String word, Node root, int idx) {
    	if (idx == word.length()) return;
    	char c = word.charAt(idx);
    	if (root.children[c-'a'] == null) {
    		Node n = new Node();
    		root.children[c-'a'] = n;
    	}
    	
		if (idx+1 == word.length()) {
			root.children[c-'a'].isEnd = true;
		}
    	
    	insert(word, root.children[c-'a'], idx+1);
    }
    
    public boolean search(String word) {
    	return search(word, root, 0);
    }
    
    private boolean search(String word, Node root, int idx) {
    	char c = word.charAt(idx);
    	if (idx+1 == word.length()) {
    		return root.children[c-'a'] != null && root.children[c-'a'].isEnd;
    	}
    	if (root.children[c-'a'] == null) return false;
    	
    	boolean r = search(word, root.children[c-'a'], idx+1);
    	
    	return r;
    }
    
    public boolean startsWith(String prefix) {
    	return startsWith(prefix, root, 0);
    }
	
    private boolean startsWith(String prefix, Node root, int idx) {
    	if (idx == prefix.length()) return true;
    	char c = prefix.charAt(idx);
    	if (root.children[c-'a'] == null) return false;
    	
    	boolean r = startsWith(prefix, root.children[c-'a'], idx+1);
    	
    	return r;
    }
	
	public static void main(String[] args) {
		Trie obj1 = new Trie();
		obj1.insert("apple");
		System.out.println(obj1.search("app"));
		System.out.println(obj1.startsWith("app"));
		obj1.insert("app");
		System.out.println(obj1.search("app"));

	}

}
