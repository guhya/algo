package net.guhya.algo.general;

public class SearchInRotatedSortedArray {

	/**
	 * Binary search
	 * To get middle value, we do a modulo operation on original mid value and rotation value
	 * @param nums
	 * @param target
	 * @param lo
	 * @param hi
	 * @param rotate
	 * @return
	 */
	public static int searchUtil(int[] nums, int target, int lo, int hi, int rotate) {
		int mid = (lo + hi) / 2;
		if (lo > hi) return -1;
		
		int aMid = (mid+rotate+1) % nums.length;
		if (nums[aMid] == target) {
			return aMid;
		}
		
		int left = searchUtil(nums, target, lo, mid-1, rotate);
		int right = searchUtil(nums, target, mid+1, hi, rotate);
		
		return Math.max(left, right);
	}
	
	/**
	 * Check how many rotation is done to the array
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		if (nums.length == 0) return -1;
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		
		int rotate = 0;
		for (int i=0; i<nums.length-1; i++) {
			rotate++;
			if (nums[i] > nums[i+1]) break;
		}
		
		int idx = searchUtil(nums, target, 0, nums.length-1, rotate);
		return idx;
	}	
	
	public static void main(String[] args) {
		int[] nums = {1,2};
		int target = 0;
		
		int idx = search(nums, target);
		System.out.println(idx);
	}

}
