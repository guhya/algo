package net.guhya.algo.general;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
    	int result = 0;
    	
    	Map<Integer, Integer> numMap = new HashMap<>();
    	for (int i=0; i<nums.length; i++) {
    		int v = nums[i];
    		if (!numMap.containsKey(v)) {
    			int pre = !numMap.containsKey(v-1) ? 0 : numMap.get(v-1);
    			int post = !numMap.containsKey(v+1) ? 0 : numMap.get(v+1);
    			int r = pre + post + 1;
    			result = Math.max(r, result);
    			
    			numMap.put(v, r);
    			int lo = 0, hi = 0;
    			if (numMap.containsKey(v-1)) {
    				lo = v-numMap.get(v-1);
    				numMap.put(lo, r);
    			}
    			
    			if (numMap.containsKey(v+1)) {
    				hi = v+numMap.get(v+1);
    				numMap.put(hi, r);
    			}
    			
    		}
    	}
    	
        return result;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {100,4,200,1,3,2};
    	System.out.println(longestConsecutive(nums1));
    	System.out.println("+++++++++++");
    	int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
    	System.out.println(longestConsecutive(nums2));
    	System.out.println("+++++++++++");
    	int[] nums3 = {};
    	System.out.println(longestConsecutive(nums3));
    	System.out.println("+++++++++++");
    	int[] nums4 = {0};
    	System.out.println(longestConsecutive(nums4));
    	System.out.println("+++++++++++");
    	int[] nums5 = {1,2,3};
    	System.out.println(longestConsecutive(nums5));
    }
}
