package net.guhya.algo.general;

import java.util.Arrays;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int counter = t.length(), lo = 0, hi = 0, min = Integer.MAX_VALUE;
        int start = 0;
    	int[] map = new int[128];
    	for (int c : t.toCharArray()) {
    		map[c]++;
    	}
    	
    	while (hi < s.length()) {
    		int chi = s.charAt(hi);
    		if (map[chi] > 0) counter--;
    		map[chi]--;
    		hi++;
    		while (counter == 0) {
    			if (hi-lo < min) {
    				min = hi-lo;
    				start = lo;
    			}
    			int clo = s.charAt(lo);
    			if (map[clo] == 0) counter++;
    			map[clo]++;
    			lo++;
    		}
    	}
    	
    	return min == Integer.MAX_VALUE ? "" : s.substring(start, start+min);
    }	
	public static void main(String[] args) {
		String s = "ABAACBAB";
		String t = "ABC";
		
		System.out.println(minWindow(s, t));
	}

}
