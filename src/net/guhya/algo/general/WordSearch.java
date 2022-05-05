package net.guhya.algo.general;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static boolean existUtil(char[][] board, String word, String sub, int row, int col, Set<String> visited) {
    	sub = sub + board[row][col];
    	if (sub.equals(word)) return true;
    	
    	boolean up = false, right = false, down = false, left = false;
    	if (row > 0 && word.charAt(sub.length()) == board[row-1][col]) {
        	String vk = (row-1)+","+col;
    		if (!visited.contains(vk)) {
	    		Set<String> newVisited = new HashSet<>(visited);
	        	newVisited.add(vk);
	    		up = existUtil(board, word, sub, row-1, col, newVisited);
    		}
    	}
    	
    	if (col < board[0].length-1 && word.charAt(sub.length()) == board[row][col+1]) { 
        	String vk = row+","+(col+1);
    		if (!visited.contains(vk)) {
	    		Set<String> newVisited = new HashSet<>(visited);
	        	newVisited.add(vk);
	    		right = existUtil(board, word, sub, row, col+1, newVisited);
    		}
    	}
    	
    	if (row < board.length-1 && word.charAt(sub.length()) == board[row+1][col]) {
        	String vk = (row+1)+","+col;
    		if (!visited.contains(vk)) {
	    		Set<String> newVisited = new HashSet<>(visited);
	        	newVisited.add(vk);
	    		down = existUtil(board, word, sub, row+1, col, newVisited);
    		}
    	}
    	
    	if (col > 0 && word.charAt(sub.length()) == board[row][col-1]) {
        	String vk = row+","+(col-1);
    		if (!visited.contains(vk)) {
	    		Set<String> newVisited = new HashSet<>(visited);
	        	newVisited.add(vk);
	    		left = existUtil(board, word, sub, row, col-1, newVisited);
    		}
    	}
    	
    	return up || right || down || left;
    }	
    
    public static boolean exist(char[][] board, String word) {
    	for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        			String vk = i+","+j;
    	    		Set<String> visited = new HashSet<>();
    	        	visited.add(vk);
	        		if (existUtil(board, word, "", i, j, visited)) {
	        			return true;
	        		}
        		}
        	}
    	}
    	return false;
    }	
    
    public static boolean existWord(char[][] board, String word) {
    	for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[0].length; j++) {
        		if (board[i][j] == word.charAt(0)) {
        	    	int[][] visited = new int[board.length][board[0].length];
	        		if (findWord(board, word, i, j, 0, visited))
	        			return true;
        		}
        	}
    	}
    	return false;
    }	

    public static boolean findWord(char[][] board, String word, int row, int col, int idx, int[][] visited) {
    	if (row < 0 || row == board.length) return false;
    	if (col < 0 || col == board[0].length) return false;
    	if (visited[row][col] == 1) return false;
    	
    	char c = word.charAt(idx);
    	if (board[row][col] != c) return false;
    	
    	visited[row][col] = 1;
    	if (idx == word.length()-1) {
    		return true;
    	}
    	
    	boolean up = false, right = false, down = false, left = false;
		up 		= findWord(board, word, row-1, col, idx+1, visited);
		right 	= findWord(board, word, row, col+1, idx+1, visited);
		down 	= findWord(board, word, row+1, col, idx+1, visited);
		left 	= findWord(board, word, row, col-1, idx+1, visited);
    	boolean result = up || right || down || left;
    	
    	if (!result) {
    		visited[row][col] = 0;
    	}
    	
    	return result;
    }
	
	public static void main(String[] args) {
		char[][] board1 = { {'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}};
		String word1 = "ABCCEDS";
		System.out.println(exist(board1, word1));
		System.out.println(existWord(board1, word1));
		System.out.println("++++++++++++++");
		
		char[][] board2 = { {'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'}};
		String word2 = "SEED";
		System.out.println(exist(board2, word2));
		System.out.println(existWord(board2, word2));
		System.out.println("++++++++++++++");
		
		char[][] board3 = { {'C','A','A'},
							{'A','A','A'},
							{'B','C','D'}};
		String word3 = "AAB";
		System.out.println(exist(board3, word3));
		System.out.println(existWord(board3, word3));
		
		System.out.println("++++++++++++++");
		char[][] board4 = { {'A','B','C','E'},
							{'S','F','E','S'},
							{'A','D','E','E'}};
		String word4 = "ABCEFSADEESE";
		System.out.println(exist(board4, word4));
		System.out.println(existWord(board4, word4));
		
		System.out.println("++++++++++++++");
		char[][] board5 = { {'A','A'}};
		String word5 = "AAA";
		System.out.println(exist(board5, word5));
		System.out.println(existWord(board5, word5));
		
	}

}
