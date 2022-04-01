package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
    	Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
    	Arrays.sort(nums);
    	
    	for (int i=0; i<nums.length-2; i++) {
    		int c = nums[i];
    		if (i > 0 && c == nums[i-1]) {
    			continue;
    		}
    		int lo = i+1;
    		int hi = nums.length-1;
    		while (lo < hi) {
    			int sum = c + nums[lo] + nums[hi];
    			if (sum <= 0) {
    				if (sum == 0) {
    					ArrayList<Integer> triplet = new ArrayList<>();
    					triplet.add(c);
    					triplet.add(nums[lo]);
    					triplet.add(nums[hi]);
    					resultSet.add(triplet);
    				}
    				lo++;
    			} else {
    				hi--;
    			}
    		}
    	}
    	
    	return new ArrayList<>(resultSet);
    }
	
	
	public static void main(String[] args) {
		int[] arr = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(arr));
	}

}
