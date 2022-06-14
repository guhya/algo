package net.guhya.algo.general;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Set to automatically filter out duplicate values
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
    	Set<Integer> numSet = new HashSet<>();
    	for(int i=0; i<nums.length; i++) {
    		if(!numSet.add(nums[i])) {
    			return true;
    		}
    	}
    	
        return false;
    }

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,1};
		System.out.println(containsDuplicate(nums1));
		System.out.println("++++++++++");
		int[] nums2 = {1,2,3,4};
		System.out.println(containsDuplicate(nums2));
		System.out.println("++++++++++");
		int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(containsDuplicate(nums3));
		System.out.println("++++++++++");
	}

}
