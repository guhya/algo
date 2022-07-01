package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    /**
     * Three sum which add up to target 0
     * Sort array
     * Get fix value (first element)
     * From next element after this fix until the end, calculate the sum
     * If sum is less than target, increase lo pointer
     * If sum is more than target, decrease hi pointer
     * If sum is equal than target, include in the result, increase lo or decrease it don't matter
     *      
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
    	Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
    	Arrays.sort(nums);
    	
    	for (int i=0; i<nums.length-2; i++) {
    		int c = nums[i];
    		int lo = i+1;
    		int hi = nums.length-1;
    		while (lo < hi) {
    			int sum = c + nums[lo] + nums[hi];
    			if (sum < 0) {
    				lo++;
    			} else if (sum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(c);
                    triplet.add(nums[lo]);
                    triplet.add(nums[hi]);
                    resultSet.add(triplet);
                    lo++;
    			} else {
    				hi--;
    			}
    		}
    	}
    	
    	return new ArrayList<>(resultSet);
    }
	
	
	public static void main(String[] args) {
		int[] arr1 = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(arr1));
		System.out.println("+++++++++++");
		
        int[] arr2 = {-1,0,1,1,-1,-3,5,2,3,-3};
        System.out.println(threeSum(arr2));
        System.out.println("+++++++++++");
	}

}
