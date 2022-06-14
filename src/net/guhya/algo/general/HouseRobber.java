package net.guhya.algo.general;

public class HouseRobber {

    /**
     * Brute force with memoization
     * @param nums
     * @param idx
     * @param memo
     * @return
     */
    public static int robUtil(int[] nums, int idx, int[] memo) {
    	if (idx >= nums.length) return 0;
    	if (memo[idx] > 0) return memo[idx];
    	if (memo[idx] < 0) return 0;
    	
    	int two = nums[idx] + robUtil(nums, idx + 2, memo);
    	int three = nums[idx] + robUtil(nums, idx + 3, memo);
    	int max = Math.max(two, three);
    	memo[idx] = max == 0 ? -1 : max;
    			
        return max;
    }
	
	
    public static int rob(int[] nums) {
    	int[] memo = new int[nums.length];
        return Math.max(robUtil(nums, 0, memo), robUtil(nums, 1, memo));
    }
	
	public static void main(String[] args) {
		int[] nums1 = {2,7,9,3,1};
		System.out.println(rob(nums1));
		System.out.println("++++++++++");
		int[] nums2 = {2,7,9,13,1};
		System.out.println(rob(nums2));
		System.out.println("++++++++++");
		int[] nums3 = {0,0,0,0,0,0,0,0,0,0,0,0,2,3,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(rob(nums3));
	}

}
