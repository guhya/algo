package net.guhya.algo.general;

public class MaximumSubarray {
	
    public static int maxSubArray(int[] nums) {
    	int sum = nums[0];
    	int maxSum = sum;
    	int i = 1;
    	while (i < nums.length) {
    		sum = Math.max(sum + nums[i], nums[i]);
    		maxSum = Math.max(sum, maxSum);
    		i++;
    	}
    	
        return maxSum;
    }

	public static void main(String[] args) {
		int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums1));
		
		int[] nums2 = {5,4,-1,7,8};
		System.out.println(maxSubArray(nums2));
	}

}
