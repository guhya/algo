package net.guhya.algo.general;

import java.util.Arrays;

public class HouseRobberII {

    public static int robUtil(int[] nums, int idx, int end, int[] memo) {
    	if (idx >= end) return 0;
    	if (memo[idx] > -1) return memo[idx];
    	
    	int two = nums[idx] + robUtil(nums, idx + 2, end, memo);
    	int three = nums[idx] + robUtil(nums, idx + 3, end, memo);
    	int max = Math.max(two, three);
    	memo[idx] = max;
    			
        return max;
    }
	
	
    public static int rob(int[] nums) {
    	int[] memo = new int[nums.length];
    	Arrays.fill(memo, -1);
        int first = Math.max(robUtil(nums, 0, nums.length-1, memo), robUtil(nums, 1, nums.length-1, memo));
    	Arrays.fill(memo, -1);
        int second = Math.max(robUtil(nums, 1, nums.length, memo), robUtil(nums, 2, nums.length, memo));
        
        return Math.max(first, second);
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,1};
		System.out.println(rob(nums1));
		System.out.println("++++++++++");
		int[] nums2 = {1,2,3};
		System.out.println(rob(nums2));
		System.out.println("++++++++++");
		int[] nums3 = {1,2};
		System.out.println(rob(nums3));
		System.out.println("++++++++++");
		int[] nums4 = {1,2,1,1};
		System.out.println(rob(nums4));
		System.out.println("++++++++++");
		int[] nums5 = {6,6,4,8,4,3,3,10};
		System.out.println(rob(nums5));
		System.out.println("++++++++++");
	}

}
