package net.guhya.algo.general;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", "");
    	if (s.length() == 0) return false;
    	int lo = 0, hi = s.length()-1;
    	while (lo < hi) {
    		if (s.charAt(lo) != s.charAt(hi)) {
    			return false;
    		}
    		lo++;
    		hi--;
    	}
    	
        return true;
    }
    
	public static void main(String[] args) {
		String s = "0P";
		System.out.println(isPalindrome(s));

	}

}
