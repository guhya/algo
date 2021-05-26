package net.guhya.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Queen {

	private static boolean isThreatened(int[][] board) {
		int rl = board.length;
		int cl = board[0].length;
		
		if (rl != cl) throw new IllegalArgumentException();
		
		for (int i=0; i<rl; i++) {
			for (int j=0; j<cl; j++) {
				if (board[i][j] == 1) {
					int upper = i-1;
					int lower = i+1;
					
					if (upper > -1) {
						if (j-1 > -1 && board[upper][j-1] == 1) return true;
						if (board[upper][j] == 1) return true;
						if (j+1 < cl && board[upper][j+1] == 1) return true;
					}
					
					if (lower < rl) {
						if (j-1 > -1 && board[lower][j-1] == 1) return true;
						if (board[lower][j] == 1) return true;
						if (j+1 < cl && board[lower][j+1] == 1) return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/* Using List is important because order of entry matters */
	private static List<List<Character>> shuffle(char[] word, List<Character> used, List<List<Character>> result) {
		if (used.size() == word.length) {
			// If all characters are used, then we're done
			result.add(used);
		} else {
			int wl = word.length;
			// Iterate for all characters
			for (int i=0; i<wl; i++) {
				Character c = word[i];
				
				// We make sure to keep track of all used characters
				List<Character> newUsed = new ArrayList<>();
				newUsed.addAll(used);
				
				// Only consider characters which are not already used
				int diff = newUsed.isEmpty() ? 2 : Math.abs(c - newUsed.get(newUsed.size()-1));
				if (!newUsed.contains(c) && diff > 1) {
					newUsed.add(c);
					shuffle(word, newUsed, result);
				}
			}
		}
		
		return result;
		
	}
	
	private static void drawBoard(List<List<Character>> coordinate) {
		int l = coordinate.size()-1;
		
		for (int i=0; i<l; i++) {
			List<Character> positionList = coordinate.get(i);
			
			System.out.println(positionList);
			int boardLength = positionList.size();
			for (int j=0; j<boardLength; j++) {
				int qPos = positionList.get(j);
				for (int k=0; k<boardLength; k++) {
					int index = k + 49;
					if (index == qPos) {
						System.out.print("Q ");
					} else {
						System.out.print("- ");
					}
				}
				System.out.println("");
			}
			System.out.println("___________");
		}
	};

	
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 1},
						 {0, 1, 0, 0},
						 {0, 0, 0, 1},
						 {1, 0, 0, 0}};
		
		System.out.println(isThreatened(board));
		
		char[] word = {'1', '2', '3', '4'};
		List<List<Character>> result = 
				shuffle(word, new ArrayList<Character>(), new ArrayList<>());
		
		drawBoard(result);
		
	}

}
