package net.guhya.algo.general;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * Use lo and hi pointer
     * Both pointer only moves to the right
     * Save visited character in the array charmap
     * Everytime new character is already visited, update lo position
     * To update lo :
     *              - Get position of visited character
     *              - If new lo position will be less than current position, don't update lo
     * Get the length between hi and lo as max
     * @param s
     * @return
     */
    private static int longest(String s) {
        int max = 0;
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int lo = 0;
        int hi = 0;
        for (hi=0; hi<s.length(); hi++) {
            int c = s.charAt(hi);
            if (charMap[c] > -1) {
                lo = Math.max(lo, charMap[c] + 1);
                max = Math.max(max, hi-lo-1);
            }
            charMap[c] = hi;
            max = Math.max(max, hi-lo+1);
        }
        
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longest("abbda"));
        System.out.println(longest("abcabcbb"));
        System.out.println(longest("au"));
    }

}
