package net.guhya.algo.general;

public class Palindrome {

	public static boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        
        while (lo < hi) {
            if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
         
        return true;
    }
    
    public static String longestPalindrome(String s) {
    	int max = 0;
    	String longest = "";
    	for (int i=0; i<s.length(); i++) {
        	for (int j=i; j<=s.length(); j++) {
        		String sub = s.substring(i, j);
        		if (isPalindrome(sub)) {
        			if (sub.length() > max) {
            			max = sub.length();
        				longest = sub;
        			}
        		}
        	}
    	}
    	
    	return longest;
    }
	
    public static String dpLongestPalindrome(String str) {

        int N = str.length();
        int palindrome_begins_at = 0;
        int palindrome_length = 1;

        boolean ispalindrome_table[][] = new boolean[N][N];

        // Base case: Every character in a string is a palindrome.
        for (int i=0; i<N; i++) {
            ispalindrome_table[i][i] = true;
        }

        // Base case: Same adjacent characters in a string make a palindrome.
        for (int i=0; i<N-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
               ispalindrome_table[i][i+1] = true;
               palindrome_length = 2;
               palindrome_begins_at = i;
            }
        }

        // Loop from string length of size 3 upto the N 
        for (int len=2; len <= N; len++) {
            for (int i=0; i < N-len+1; i++) {
                int j = i+len-1;
                if (str.charAt(i) == str.charAt(j) && ispalindrome_table[i+1][j-1] == true) {
                   ispalindrome_table[i][j] = true;
                   if (len > palindrome_length) {
                      palindrome_begins_at = i;
                      palindrome_length = len;
                   }
                }
            }
        }

        System.out.println("Length of the longest palindrome : " + palindrome_length);
        return str.substring(palindrome_begins_at, palindrome_begins_at + palindrome_length);
    }    
	
	public static void main(String[] args) {
		String s = "aabcd";
		System.out.println(dpLongestPalindrome(s));
        System.out.println(longestPalindrome(s));
	}

}
