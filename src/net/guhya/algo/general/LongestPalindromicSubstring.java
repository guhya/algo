package net.guhya.algo.general;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
    	if (s.length() == 1) return s;
    	String longest = s.charAt(0) + "";
    	for(int i=0; i<s.length(); i++) {
    		String odd = expand(s, i, i);
    		if (odd.length() > longest.length()) {
    			longest = odd;
    		}
    		
    		String even = expand(s, i, i+1);
    		if (even.length() > longest.length()) {
    			longest = even;
    		}
    		
    	}
    	
    	return longest;
    }
    
    private static String expand(String s, int lo, int hi) {
    	while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
    		lo--;
    		hi++;
    	}
    	lo++;
    	return s.substring(lo, hi);
    }
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println("++++++++++");
		System.out.println(longestPalindrome("cbbd"));
		System.out.println("++++++++++");
		System.out.println(longestPalindrome("asfkasljfdfdcbbddfaskfjracecarsda"));
		System.out.println("++++++++++");
	}

}
