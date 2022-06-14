package net.guhya.algo.general;

import java.util.Arrays;

public class ValidAnagram {
	
    public static boolean isAnagram(String s, String t) {
    	int count = 0;
    	int[] cArr = new int[26];
    	for (int cs : s.toCharArray()) {
    		cArr[cs-'a']++;
    		count++;
    	}
    	
    	for (int ct : t.toCharArray()) {
    		if (cArr[ct-'a'] > 0) {
	    		cArr[ct-'a']--;
	    		count--;
    		} else {
    			return false;
    		}
    	}
    	System.out.println(Arrays.toString(cArr));
        return count == 0;
    }

	public static void main(String[] args) {
		String a1 = "anagram";
		String a2 = "nagaram";
		System.out.println(isAnagram(a1, a2));
		String b1 = "aacc";
		String b2 = "ccac";
		System.out.println(isAnagram(b1, b2));
		
	}

}
