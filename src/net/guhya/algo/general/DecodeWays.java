package net.guhya.algo.general;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static int numDecodingsUtil(String s, String sub, String path, Map<String, Integer> memo) {
    	if (sub.length() > 0) {
	    	path += sub + ",";
	        if (sub.charAt(0) == '0') {
	        	return 0;
	        }
	        
	        int c = Integer.valueOf(sub);
	    	if (c > 26) {
	    		return 0;
	    	}
	    	
	        if (s.length() == 0) {
	        	System.out.println(path);
	        	return 1;
	        }
	        
	    	if (memo.get(s) != null) {
	    		return memo.get(s);
	    	} 
    	}
    	
    	int one = numDecodingsUtil(s.substring(1), s.substring(0, 1), path, memo);
    	int two = 0;
    	if (s.length() >= 2) {
    		two = numDecodingsUtil(s.substring(2), s.substring(0, 2), path, memo);
    	}
    	
    	int result = one + two;
    	memo.put(s, result);
    	
    	return result;
    }
	
    public static int numDecodings(String s) {
    	Map<String, Integer> memo = new HashMap<String, Integer>();
        int r = numDecodingsUtil(s, "", "", memo);
        System.out.println(memo);
        
        return r;
    }
	
	
	public static void main(String[] args) {
		/*
		System.out.println(numDecodings("11106"));
		System.out.println("+++++++++++");
		System.out.println(numDecodings("12"));
		System.out.println("+++++++++++");
		System.out.println(numDecodings("226"));
		System.out.println("+++++++++++");
		System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
		System.out.println("+++++++++++");
		*/
		System.out.println(numDecodings("123123"));
	}

}
