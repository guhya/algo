package net.guhya.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {
    
    static int counter = 0;

    private static List<String> lis(int[] nums) {
        counter = 0;
        String r = lisHelper(nums, Integer.MIN_VALUE, 0);
        System.out.print(counter + " -> ");
        return Arrays.asList(r.split(","));
    }

    private static List<String> lisMemo(int[] nums) {
        counter = 0;
        Map<String, String> memo = new HashMap<>();
        String r = lisHelperMemo(nums, Integer.MIN_VALUE, 0, memo);
        System.out.print(counter + " -> ");
        return Arrays.asList(r.split(","));
    }

    private static List<Integer> lisHelper(int[] nums, int prev, int lo, List<Integer> path) {
        if (lo == nums.length) return new ArrayList<>(path);
        
        if (nums[lo] > prev) {
            List<Integer> excluded = lisHelper(nums, prev, lo+1, new ArrayList<>(path));
            path.add(nums[lo]);
            List<Integer> included = lisHelper(nums, nums[lo], lo+1, new ArrayList<>(path));
            if (excluded.size() > included.size()) {
                return excluded;
            } else {
                return included;
            }
        } else {
            List<Integer> r = lisHelper(nums, prev, lo+1, new ArrayList<>(path));
            return r;
        }
    }

    private static String lisHelper(int[] nums, int prev, int lo) {
        if (lo == nums.length) return "";
        counter++;
        
        if (nums[lo] > prev) {
            String included = nums[lo] + "," + lisHelper(nums, nums[lo], lo+1);
            String excluded = lisHelper(nums, prev, lo+1);
            String r = (excluded.length() > included.length()) ? excluded : included;
            return r;
        } else {
            String r = lisHelper(nums, prev, lo+1);
            return r;
        }
    }

    private static String lisHelperMemo(int[] nums, int prev, int lo, Map<String, String> memo) {
        if (lo == nums.length) return "";
        if (memo.containsKey(prev+":"+lo)) {
            return memo.get(prev+":"+lo);
        }
        counter++;
        
        if (nums[lo] > prev) {
            String included = nums[lo] + "," + lisHelperMemo(nums, nums[lo], lo+1, memo);
            String excluded = lisHelperMemo(nums, prev, lo+1, memo);
            String r = (excluded.length() > included.length()) ? excluded : included;
            memo.put(prev+":"+lo, r);
            return r;
        } else {
            String r = lisHelperMemo(nums, prev, lo+1, memo);
            memo.put(prev+":"+lo, r);
            return r;
        }
    }

    private static int intlisHelper(int[] nums, int prev, int lo) {
        if (lo == nums.length) return 0;
        
        if (nums[lo] > prev) {
            int included = 1 + intlisHelper(nums, nums[lo], lo+1);
            int excluded = intlisHelper(nums, prev, lo+1);
            int r = (excluded > included) ? excluded : included;
            return r;
        } else {
            int r = intlisHelper(nums, prev, lo+1);
            return r;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,5,2,3};
        System.out.println(lis(nums1));
        System.out.println(lisMemo(nums1));
        System.out.println("+++++++++++");
        
        int[] nums2 = {2,5,1,8,1,2,3,0,6};
        System.out.println(lis(nums2));
        System.out.println(lisMemo(nums2));
        System.out.println("+++++++++++");
        
        int[] nums3 = {1,1001,100,5,6,7,8,9};
        System.out.println(lis(nums3));
        System.out.println(lisMemo(nums3));
        System.out.println("+++++++++++");
        
        int[] nums4 = {1,5,2,3,1,1001,0,2,5,1,8,1,2,3,0,6,5,6,7,8,9};
        System.out.println(lis(nums4));
        System.out.println(lisMemo(nums4));
        System.out.println("+++++++++++");
    }

}
