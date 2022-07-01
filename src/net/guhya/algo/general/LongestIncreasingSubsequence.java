package net.guhya.algo.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    /**
     * Use greedy approach (patience sort) for interesting solution
     * https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/LongestIncreasingSubsequence-2x2.pdf
     * As long as we put the card to the left most pile that fits, strong duality is achieved,
     * which is number of longest increasing subsequence = number of card piles.
     * Complexity is O(N*N) because of inner loop to place card to the correct pile.
     * Card on the piles array is sorted, so we can reduce complexity to O(NlogN) using binary
     * search.
     * @param nums
     * @return
     */
    private static int lisGreedy(int[] nums) {
        int[] piles = new int[nums.length];
        Arrays.fill(piles, Integer.MAX_VALUE);
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<piles.length; j++) {
                if (nums[i] <= piles[j]) {
                    if (piles[j] == Integer.MAX_VALUE) count++;
                    piles[j] = nums[i];
                    break;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Do binary search to place card to the correct piles
     * @param nums
     * @return
     */
    private static int lisGreedyBinarySearch(int[] nums) {
        int[] piles = new int[nums.length];
        Arrays.fill(piles, Integer.MAX_VALUE);
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int idx = searchHelper(piles, 0, nums.length-1, nums[i]);
            piles[idx] = nums[i];
        }
        
        for (int i=0; i<piles.length; i++) {
            if (piles[i] == Integer.MAX_VALUE) break;
            count++;
        }
        
        return count;
    }
    
    private static int searchHelper(int[] piles, int lo, int hi, int val) {
        if (lo > hi) return -1;
        
        int mid = (lo + hi) / 2;
        if (piles[mid] >= val) {
            if (mid == 0) {
                return mid;
            } else {
                if(piles[mid-1] == val) {
                    return mid-1;
                } else if(piles[mid-1] < val) {
                    return mid;
                } else {
                    return searchHelper(piles, lo, mid-1, val);
                }
            }
        } else if (piles[mid] < val){
            return searchHelper(piles, mid+1, hi, val);
        } else {
            return mid+1;
        }
    }
    
    
    /**
     * Brute force
     * @param nums
     * @return
     */
    private static int lisRecursive(int[] nums) {
        count = 0;
        int max = lisRecursiveHelper(nums, 0, Integer.MIN_VALUE);
        return max;
    }

    /**
     * Brute force
     * @param nums
     * @return
     */
    private static int lisRecursiveMemo(int[] nums) {
        count = 0;
        memo.clear();
        int max = lisRecursiveHelperMemo(nums, 0, Integer.MIN_VALUE);
        return max;
    }

    static int count = 0;
    static Map<String, Integer> memo = new HashMap<>();
    private static int lisRecursiveHelper(int[] nums, int idx, int prev) {
        if (idx == nums.length) return 0;
        
        count++;
        int excluded = lisRecursiveHelper(nums, idx+1, prev);
        int included = 0;
        if (nums[idx] > prev) {
            included = 1 + lisRecursiveHelper(nums, idx+1, nums[idx]);
        }
        
        int max = Math.max(included, excluded);
        
        return max;
    }
    
    private static int lisRecursiveHelperMemo(int[] nums, int idx, int prev) {
        if (idx == nums.length) return 0;
        if (memo.containsKey(idx+"|"+prev)) return memo.get(idx+"|"+prev);
        
        count++;
        int excluded = lisRecursiveHelperMemo(nums, idx+1, prev);
        int included = 0;
        if (nums[idx] > prev) {
            included = 1 + lisRecursiveHelperMemo(nums, idx+1, nums[idx]);
        }
        
        int max = Math.max(included, excluded);
        memo.put(idx+"|"+prev, max);
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lisGreedy(nums));
        System.out.println(lisGreedyBinarySearch(nums));
        System.out.println(lisRecursive(nums) + " " + count);
        System.out.println(lisRecursiveMemo(nums) + " " + count);
        System.out.println("+++++++++++");
        
        int[] nums1 = {0,1,0,3,2,3};
        System.out.println(lisGreedy(nums1));
        System.out.println(lisGreedyBinarySearch(nums1));
        System.out.println(lisRecursive(nums1) + " " + count);
        System.out.println(lisRecursiveMemo(nums1) + " " + count);
        System.out.println("+++++++++++");
        
        int[] nums2 = {1,3,6,7,9,4,10,5,6};
        System.out.println(lisGreedy(nums2));
        System.out.println(lisGreedyBinarySearch(nums2));
        System.out.println(lisRecursive(nums2) + " " + count);
        System.out.println(lisRecursiveMemo(nums2) + " " + count);
        System.out.println("+++++++++++");
        
        int[] nums3 = {0,1,0,3,2,3};
        System.out.println(lisGreedy(nums3));
        System.out.println(lisGreedyBinarySearch(nums3));
        System.out.println(lisRecursive(nums3) + " " + count);
        System.out.println(lisRecursiveMemo(nums3) + " " + count);
        System.out.println("+++++++++++");
        
        int[] nums4 = {7,7,7,7,7,7,7};
        System.out.println(lisGreedy(nums4));
        System.out.println(lisGreedyBinarySearch(nums4));
        System.out.println(lisRecursive(nums4) + " " + count);
        System.out.println(lisRecursiveMemo(nums4) + " " + count);
        System.out.println("+++++++++++");
        
        int[] nums5 = {17,3,2,3,6,60,2,3,4,5,6,7,8,17};
        System.out.println(lisGreedy(nums5));
        System.out.println(lisGreedyBinarySearch(nums5));
        System.out.println(lisRecursive(nums5) + " " + count);
        System.out.println(lisRecursiveMemo(nums5) + " " + count);
        System.out.println("+++++++++++");
        
    }


}
