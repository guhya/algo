package net.guhya.algo.general;

import java.util.HashMap;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
    	int bestMax = nums[0], currentMax = bestMax, currentMin = bestMax;
    
    	for (int i=1; i<nums.length; i++) {
    		int tmpMin = Math.min(nums[i], Math.min(nums[i] * currentMin, nums[i] * currentMax));
    		int tmpMax = Math.max(nums[i], Math.max(nums[i] * currentMin, nums[i] * currentMax));
    		
    		currentMin = Math.min(tmpMin, tmpMax);
    		currentMax = Math.max(tmpMin, tmpMax);
    		
    		bestMax = Math.max(bestMax, currentMax);
    	}
    	
        return bestMax;
    }	
    
    static int bestMax = 0;
    public static void maxProductUtil(int[] nums, int lo, int hi, HashMap<String, Integer> memo) {
    	
    	if (lo>hi) return;
    	if (memo.containsKey(lo+"->"+hi)) return;
    	
    	int product = 1;
    	for (int i=lo; i<=hi; i++) {
    		product *= nums[i];
    		if (product == 0) break;
    	}
    	memo.put(lo+"->"+hi, product);
    	bestMax = Math.max(bestMax, product);
    	//System.out.println(lo + "->" + hi + "=" + product);
    	
    	maxProductUtil(nums, lo, hi-1, memo);
    	maxProductUtil(nums, lo+1, hi, memo);
    	
    }
    
	public static void main(String[] args) {
		/*
		int[] nums1 = {2,3,-2,4};
		System.out.println(maxProduct(nums1));
		System.out.println("++++++++++");
		
		int[] nums2 = {-2,3,-4};
		System.out.println(maxProduct(nums2));
		System.out.println("++++++++++");
		
		int[] nums3 = {0,-2,3,-4};
		System.out.println(maxProduct(nums3));
		System.out.println("++++++++++");
		
		int[] nums4 = {-2};
		System.out.println(maxProduct(nums4));
		System.out.println("++++++++++");
		*/
		
		//int[] nums5 = {2,-5,-2,-4,3};
		int[] nums5 = {-2,0,3};
		System.out.println(maxProduct(nums5));
		System.out.println("++++++++++");
		
		//int[] nums6 = {2,-5,-2,-4,3};
		int[] nums6 = {0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2};
		bestMax = nums6[0];
		maxProductUtil(nums6, 0, nums6.length-1, new HashMap<String, Integer>());
		System.out.println(bestMax);
		System.out.println("++++++++++");
	}
}
