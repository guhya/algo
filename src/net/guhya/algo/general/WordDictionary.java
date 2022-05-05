package net.guhya.algo.general;

public class WordDictionary {

	class Node {
		Node[] children;
		boolean isEnd;
		
		public Node() {
			children = new Node[26];
			isEnd = false;
		}
	}

	Node root;
	
    public WordDictionary() {
    	root = new Node();
    }
    
    public void addWord(String word) {
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
    	return search(word, root, 0) > 0;
    }
    
    private int search(String word, Node root, int idx) {
    	char c = word.charAt(idx);
    	int r = 0;
    	if (c == '.') {
        	if (idx+1 == word.length()) {
            	for (int i=0; i<26; i++) {
            		if (root.children[i] != null && root.children[i].isEnd) {
            			r = 1;
            			break;
            		}
            	}
        		return r;
        	}
        	for (int i=0; i<26; i++) {
        		if (root.children[i] != null) {
        			r += search(word, root.children[i], idx+1);
        		}
        	}
    	} else {
        	if (idx+1 == word.length()) {
        		return root.children[c-'a'] != null && root.children[c-'a'].isEnd ? 1 : 0;
        	}
        	if (root.children[c-'a'] == null) return 0;
        	r += search(word, root.children[c-'a'], idx+1);
    	}
    	
    	return r;
    }
	
	public static void main(String[] args) {
		WordDictionary obj1 = new WordDictionary();
		obj1.addWord("at");
		obj1.addWord("and");
		obj1.addWord("an");
		obj1.addWord("add");
		System.out.println(obj1.search("b."));
		System.out.println(obj1.search("a.d"));
		System.out.println(obj1.search("."));
	}

}
