package net.guhya.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    static int count = 0;
    
    private static int longest(int[] arr1, int[] arr2) {
        count = 0;
        int longest = longestHelper(arr1, arr2, 0, 0);
        System.out.print(count + " -> ");
        return longest;
    }
    
    private static int longestHelper(int[] arr1, int[] arr2, int lo1, int lo2) {
        if (lo1 == arr1.length || lo2 == arr2.length) return 0;
        count++;
        
        if (arr1[lo1] == arr2[lo2]) {
            return 1 + longestHelper(arr1, arr2, lo1+1, lo2+1);
        } else {
            int left = longestHelper(arr1, arr2, lo1+1, lo2);
            int right = longestHelper(arr1, arr2, lo1, lo2+1);
            int max = Math.max(left, right);
            
            return max;
        }
    }
    
    private static int longestMemo(int[] arr1, int[] arr2) {
        count = 0;
        int[][] memo = new int[arr1.length][arr2.length];
        int longest = longestMemoHelper(arr1, arr2, 0, 0, memo);
        System.out.print(count + " -> ");
        return longest;
    }
    
    private static int longestMemoHelper(int[] arr1, int[] arr2, int lo1, int lo2, int[][] memo) {
        if (lo1 == arr1.length || lo2 == arr2.length) return 0;
        if (memo[lo1][lo2] > 0) return memo[lo1][lo2];
        count++;
        
        if (arr1[lo1] == arr2[lo2]) {
            int r = 1 + longestMemoHelper(arr1, arr2, lo1+1, lo2+1, memo);
            memo[lo1][lo2] = r;
            return r;
        } else {
            int left = longestMemoHelper(arr1, arr2, lo1+1, lo2, memo);
            int right = longestMemoHelper(arr1, arr2, lo1, lo2+1, memo);
            int max = Math.max(left, right);
            memo[lo1][lo2] = max;
            
            return max;
        }
    }

    private static int longestMemoPath(int[] arr1, int[] arr2) {
        count = 0;
        Map<String, String> memo = new HashMap<>();
        String longest = longestMemoPathHelper(arr1, arr2, 0, 0, memo);
        System.out.print(longest.substring(0, longest.length()-1) + " => " + count + " -> ");
        return longest.split(",").length;
    }

    private static String longestMemoPathHelper(int[] arr1, int[] arr2, int lo1, int lo2, Map<String, String> memo) {
        if (lo1 == arr1.length || lo2 == arr2.length) {
            return "";
        }
        
        if (memo.containsKey(lo1+":"+lo2)) {
            String v = memo.get(lo1+":"+lo2);
            if (v.split(",").length > 0) {
                return v;
            }
        }
        
        count++;
        
        if (arr1[lo1] == arr2[lo2]) {
            String r = arr1[lo1] + "," + longestMemoPathHelper(arr1, arr2, lo1+1, lo2+1, memo);
            memo.put(lo1+":"+lo2, r);
            return r;
        } else {
            String left = longestMemoPathHelper(arr1, arr2, lo1+1, lo2, memo);
            String right = longestMemoPathHelper(arr1, arr2, lo1, lo2+1, memo);
            String max = left.length() > right.length() ? left : right;
            memo.put(lo1+":"+lo2, max);
            return max;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {7,4,1};
        int[] a2 = {4,1,2,7};
        System.out.println(longest(a1, a2));
        System.out.println(longestMemo(a1, a2));
        System.out.println(longestMemoPath(a1, a2));
        System.out.println("++++++++++");
        
        int[] b1 = {1,2,7,8};
        int[] b2 = {4,1,2,7,8,4};
        System.out.println(longest(b1, b2));
        System.out.println(longestMemo(b1, b2));
        System.out.println(longestMemoPath(b1, b2));
        System.out.println("++++++++++");
        
        int[] c1 = {1,2,4,21,1,5,0,7,8,9,1,2,3};
        int[] c2 = {4,1,2,7,2,3,4,6,3,4,21,1,2,4,3,9,1,8,9,2,4};
        System.out.println(longest(c1, c2));
        System.out.println(longestMemo(c1, c2));
        System.out.println(longestMemoPath(c1, c2));
        System.out.println("++++++++++");
        
        int[] d1 = {1,2,5,1,2,3};
        int[] d2 = {4,1,2,76,1,3,2,4,3,9,1,8,9,2,4};
        System.out.println(longest(d1, d2));
        System.out.println(longestMemo(d1, d2));
        System.out.println(longestMemoPath(d1, d2));
        System.out.println("++++++++++");
        
    }

}
