package net.guhya.algo.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static int wordBreakUtil(String s, List<String> wordDict, Map<String, Integer> memo) {
    	if (s.length() == 0) {
    		return 1;
    	}
    	
    	if (memo.containsKey(s)) {
    		return memo.get(s);
    	}
    	
    	int r = 0;
    	for (String str : wordDict) {
    		if (s.length() >= str.length()) {
    			String tmp = s.substring(0, str.length());
    			if (tmp.equals(str)) {
    				r += wordBreakUtil(s.substring(str.length()), wordDict, memo);
    			}
    		}
    	}
    	
		memo.put(s, r);
    	
        return r;
    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakUtil(s, wordDict, new HashMap<>()) > 0;
    }
	
	public static void main(String[] args) {
		String s1 = "leetcode";
		String[] dict1 = {"leet", "code"};
		System.out.println(wordBreak(s1, Arrays.asList(dict1)));
		System.out.println("++++++++++");
		
		String s2 = "applepenapple";
		String[] dict2 = {"apple", "pen"};
		System.out.println(wordBreak(s2, Arrays.asList(dict2)));
		System.out.println("++++++++++");
		
		String s3 = "catsandog";
		String[] dict3 = {"cats", "dog", "sand", "and", "cat"};
		System.out.println(wordBreak(s3, Arrays.asList(dict3)));
		System.out.println("++++++++++");
		
		String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] dict4 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		System.out.println(wordBreak(s4, Arrays.asList(dict4)));
		System.out.println("++++++++++");
	}

}
