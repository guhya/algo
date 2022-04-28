package net.guhya.algo.general;

public class MinimumInRotatedSortedArray {
	
    public static int findMinUtil(int[] nums, int lo, int hi, int mid) {
    	int before = (nums.length+mid-1) % nums.length;
    	int after = (nums.length+mid+1) % nums.length;
    	
    	if (nums[after] < nums[mid]) return nums[after];
    	if (nums[mid] < nums[before]) return nums[mid];
    	
    	
    	
    	return lo;
    }
    
    static int idx = 0;
    public static void findMinUtil(int[] nums, int lo, int hi) {
    	if (lo == hi) return;
    	
    	int mid = (lo + hi) / 2;
    	int before = (nums.length+mid-1) % nums.length;
    	int after = (nums.length+mid+1) % nums.length;
    	
    	if (nums[after] < nums[mid]) {
    		idx = after;
    		return;
    	}
    	
    	if (nums[mid] < nums[before]) {
    		idx = mid;
    		return;
    	}
    	
    	
    	if (nums[mid] < nums[hi]) {
    		findMinUtil(nums, lo, mid-1);
    	} else {
    		findMinUtil(nums, mid+1, hi);
    	}
    }

    public static int findMin(int[] nums) {
    	findMinUtil(nums, 0, nums.length-1);
    	return nums[idx];
    }

	public static void main(String[] args) {
		int[] nums1 = {4,5,1,2,3};
		System.out.println(findMin(nums1));
	}
}
