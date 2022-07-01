package net.guhya.algo.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] twoSumMap(int[] nums, int n) {
        int[] result = new int[2];
        Map<Integer, Integer> numSet = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (numSet.containsKey(n - nums[i])) {
                result[1] = i;
                result[0] = numSet.get(n - nums[i]);
            }
            numSet.put(nums[i], i);
        }
        
        return result;
    }

    private static int[] twoSumMapSort(int[] nums, int n) {
        int[] result = new int[2];
        Map<Integer, Integer> numSet = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            numSet.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        int lo = 0; 
        int hi = nums.length-1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == n) {
                break;
            } else if (nums[lo] + nums[hi] > n) {
                hi--;
            } else {
                lo++;
            }
        }
        
        result[0] = numSet.get(nums[lo]);
        result[1] = numSet.get(nums[hi]);
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumMap(nums1, 9)));
        System.out.println(Arrays.toString(twoSumMapSort(nums1, 9)));
        System.out.println("++++++++++++");

        int[] nums2 = {3, 2, 4};
        System.out.println(Arrays.toString(twoSumMap(nums2, 6)));
        System.out.println(Arrays.toString(twoSumMapSort(nums2, 6)));
        System.out.println("++++++++++++");
        
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(twoSumMap(nums3, 6)));
        System.out.println(Arrays.toString(twoSumMapSort(nums3, 6)));
        System.out.println("++++++++++++");
    }


}
