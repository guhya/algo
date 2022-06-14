package net.guhya.algo.general;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
    	int[] result = new int[nums.length];
    	
		int zeroCount = 0;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] == 0) zeroCount++;
		}
    	
		if (zeroCount > 1) return result;
		int product = 1;
		for (int i=0; i<nums.length; i++) {
			int n = nums[i] == 0 ? 1 : nums[i];
			product *= n;
		}
		
    	for (int i=0; i<nums.length; i++) {
    		if (zeroCount == 1) {
    			if (nums[i] == 0) {
        			result[i] = product;
    			} else {
    				result[i] = 0;
    			}
    		} else {
    			result[i] = product / nums[i];
    		}
    	}
    	
        return result;
    }
    
    public static int[] productExceptSelfRecursive(int[] nums) {
    	int[] result = new int[nums.length];
        productExceptSelfHelper(nums, 0, result, 1);
        
        return result;
        
    }

    public static void productExceptSelfHelper(int[] nums, int idx, int[] result, int product) {
    	if (idx == nums.length) return;
    	
    	int n = nums[idx] == 0 ? 1 : nums[idx];
    	product *= n;
    	productExceptSelfHelper(nums, idx+1, result, product);
    	result[idx] = nums[idx] != 0 ? product / nums[idx] : product;
    }
    
    public static int[] productExceptSelfOptimal(int[] nums) {
    	int[] result = new int[nums.length];
    	
    	int prefix = 1;
    	for (int i=0; i<nums.length; i++) {
    		result[i] = prefix;
    		prefix = prefix * nums[i];
    	}
    	
    	int suffix = 1;
    	for (int i=nums.length-1; i>=0; i--) {
    		result[i] = result[i] * suffix;
    		suffix = suffix * nums[i];
    	}
    	
        return result;
    }
    
    
    
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(nums1)));
		System.out.println("+++++++++++");
		int[] nums2 = {-1,1,0,-3,3};
		System.out.println(Arrays.toString(productExceptSelf(nums2)));
		System.out.println("+++++++++++");
		int[] nums3 = {0,4,0};
		System.out.println(Arrays.toString(productExceptSelf(nums3)));
		System.out.println("+++++++++++");
		int[] nums4 = {5,2,3,4};
		System.out.println(Arrays.toString(productExceptSelfOptimal(nums4)));
		
	}

}
