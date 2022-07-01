package net.guhya.algo.general;

public class MaximumSubarray {
	
    /**
     * Initial sum and maximum sum is element at index 0
     * If this element and next element more than sum, set it as the new sum
     * Check if this cumulative value is more than maxsum, if yes, set it as new max sum
     * @param nums
     * @return
     */
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

    
    /**
     * Brute force
     * - Get sum of one element
     * - Get sum of two element
     * - Get sum of three element ... and so on
     * - Get the maximum after every sum
     * @param nums
     * @return
     */
    private static int max(int[] nums) {
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
    
    /**
     * This work because after every addition with the next element, we compare the max
     * @param nums
     * @return
     */
    private static int maxSquare(int[] nums) {
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
	    
		int[] nums1 = {2,1,3,4,1,2,1,5,4};
		System.out.println(maxSubArray(nums1));
        System.out.println(max(nums1));
        System.out.println(maxSquare(nums1));
		System.out.println("+++++++++++");
		
		int[] nums2 = {5,4,-1,7,8};
		System.out.println(maxSubArray(nums2));
        System.out.println(max(nums2));
        System.out.println(maxSquare(nums2));
        System.out.println("+++++++++++");
		
        int[] nums3 = {1,-4,2};
        System.out.println(maxSubArray(nums3));
        System.out.println(max(nums3));
        System.out.println(maxSquare(nums3));
        System.out.println("+++++++++++");
		
	}

}
