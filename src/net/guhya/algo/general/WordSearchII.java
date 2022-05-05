package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	
	static class Node {
		Node[] children;
		boolean isEnd;
		
		public Node() {
			children = new Node[26];
			isEnd = false;
		}
	}
	
	static Node root = new Node();
	
	private static void insert(Node root, String word, int idx) {
		if (idx == word.length()) return;
		char c = word.charAt(idx);
		if (root.children[c-'a'] == null) {
			root.children[c-'a'] = new Node();
		}
		if (idx+1 == word.length()) {
			root.children[c-'a'].isEnd = true;
		}
		
		insert(root.children[c-'a'], word, idx+1);
	}
	
	private static void findWordsUtil(char[][] board, int row, int col, int idx, Set<String> visited, Node root, String tmp, Set<String> resultList) {
		if (row < 0 || col < 0 || row == board.length || col == board[0].length) return;
		Node newNode = root.children[board[row][col]-'a'];
		if (newNode == null) return;
		String s = row+":"+col;
		if (visited.contains(s)) return;
		visited.add(s);
		tmp += board[row][col];
		if (newNode.isEnd) {
			resultList.add(tmp);
		}
		
		findWordsUtil(board, row, col+1, idx+1, visited, newNode, tmp, resultList);
		findWordsUtil(board, row+1, col, idx+1, visited, newNode, tmp, resultList);
		findWordsUtil(board, row, col-1, idx+1, visited, newNode, tmp, resultList);
		findWordsUtil(board, row-1, col, idx+1, visited, newNode, tmp, resultList);
		visited.remove(s);
	}
	
    public static List<String> findWords(char[][] board, String[] words) {
    	Set<String> resultList = new HashSet<String>();
    	root = new Node();
    	for (String s : words) {
    		insert(root, s, 0);
    	}
    	
    	for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[i].length; j++) {
        		findWordsUtil(board, i, j, 0, new HashSet<>(), root, "", resultList);
        	}
    	}
    	
    	return new ArrayList<String>(resultList);
    }
	
	public static void main(String[] args) {
		char[][] board1 = {
							{'o','a','a','n'},
							{'e','t','a','e'},
							{'i','h','k','r'},
							{'i','f','l','v'}
							};
		String[] words1 = {"oath","pea","eat","rain"};
		System.out.println(findWords(board1, words1));
		System.out.println("++++++++++");
		char[][] board2 = {
				{'a'}
				};
		String[] words2 = {"ab"};
		System.out.println(findWords(board2, words2));
		System.out.println("++++++++++");
		char[][] board3 = {
							{'o','a','b','n'},
							{'o','t','a','e'},
							{'a','h','k','r'},
							{'a','f','l','v'}};
		String[] words3 = {"oa", "oaa"};
		System.out.println(findWords(board3, words3));
	}

}
