package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
    /**
     * Comparing anagram one by one using hashmap of character counter
     * We increment counter first, and substract it later
     * In the end if hashmap is empty, then it is anagram
     * Time complexity O(m+n)
     * Space complexity O(m+n)
     * @param s1
     * @param s2
     * @return
     */
	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer> source = new HashMap<>();
		for (int i=0; i<s1.length(); i++) {
			Character c = s1.charAt(i);
			if (source.get(c) != null) {
				source.put(c, source.get(c) + 1); 
			} else {
				source.put(c, 1); 
			}
		}
		
		for (int i=0; i<s2.length(); i++) {
			Character c = s2.charAt(i);
			if (source.get(c) == null) {
				return false;
			} else {
				if (source.get(c) == 1) {
					source.remove(c);
				} else {
					source.put(c, source.get(c)-1); 
				}
			}
		}
		
		return source.isEmpty();
	}
	
	/**
	 * For each word w in the list, check if it is anagram O ((w*w)*n) 
	 * If it is, put in the correct group 
	 * @param strs
	 * @return
	 */
    public static List<List<String>> groupAnagrams(String[] strs) {
    	HashMap<String, List<String>> group = new HashMap<>();
    	for (String str2 : strs) {
    		boolean isAnagram = false;
    		for (String str1 : group.keySet()) {
    			if (isAnagram(str1, str2)) {
    				group.get(str1).add(str2);
    				isAnagram = true;
    				break;
    			} 
    		}
    		
    		if (!isAnagram) {
				List<String> list = new ArrayList<>();
				list.add(str2);
				group.put(str2, list);
    		}
    	}
    	
    	List<List<String>> result = new ArrayList<>();
    	for (String s : group.keySet()) {
    		result.add(group.get(s));
    	}
    	
        return result;
    }	
    
    /**
     * To check if a word is an anagram of the other, we can sort it first and use it as key.
     * Use the key to a group to place the anagram on the correct group if any, if key not exist,
     * then no group
     * 
     * Use hashmap to store group
     * Key is a sorted word
     * Value is list of anagrams
     * 
     * Sort anagram, if it is equals to key, add it if not create it
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsSort(String[] strs) {
    	
    	Map<String, List<String>> map = new HashMap<>();    	
    	for (String str : strs) {
    		char[] cs = str.toCharArray();
    		Arrays.sort(cs);
    		String key = String.valueOf(cs);
    		if (map.get(key) == null) map.put(key, new ArrayList<String>());
    		map.get(key).add(str);
    	}
    	
    	return new ArrayList<>(map.values());
    }
    
    
	
	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
		
		System.out.println(groupAnagramsSort(strs));
		
	}

}
