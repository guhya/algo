package net.guhya.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	/* Using List is important because order of entry matters */
	private static void shuffle(char[] word, List<Character> used) {
		if (used.size() == word.length) {
			// If all characters are used, then we're done
			System.out.println(used);
		} else {
			int wl = word.length;
			// Iterate for all characters
			for (int i=0; i<wl; i++) {
				Character c = word[i];
				
				// We make sure to keep track of all used characters
				List<Character> newUsed = new ArrayList<>();
				newUsed.addAll(used);
				
				// Only consider characters which are not already used
				if (!newUsed.contains(c)) {
					newUsed.add(c);
					shuffle(word, newUsed);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		char[] word = {'A', 'B', 'C'};
		shuffle(word, new ArrayList<Character>());
	}

}
