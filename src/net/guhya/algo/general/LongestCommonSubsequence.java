package net.guhya.algo.general;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    static int count = 0;
    static Map<String, Integer> memo = new HashMap<>();
    
    private static int lcs(String a1, String a2) {
        count = 0;
        return lcsHelper(a1, a2, a1.length()-1, a2.length()-1);
    }

    private static int lcsHelper(String a1, String a2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        
        count++;
        if (a1.charAt(i) == a2.charAt(j)) {
            return 1 + lcsHelper(a1, a2, i-1, j-1);
        } else {
            int maxi = lcsHelper(a1, a2, i-1, j);
            int maxj = lcsHelper(a1, a2, i, j-1);
            return Math.max(maxi, maxj);
        }
    }
    
    private static int lcsMemo(String a1, String a2) {
        count = 0;
        memo.clear();
        return lcsHelperMemo(a1, a2, a1.length()-1, a2.length()-1);
    }

    private static int lcsHelperMemo(String a1, String a2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (memo.containsKey(i+":"+j)) return memo.get(i+":"+j);
        
        count++;
        int max = 0;
        if (a1.charAt(i) == a2.charAt(j)) {
            max = 1 + lcsHelperMemo(a1, a2, i-1, j-1);
        } else {
            int maxi = lcsHelperMemo(a1, a2, i-1, j);
            int maxj = lcsHelperMemo(a1, a2, i, j-1);
            max = Math.max(maxi, maxj);
        }
        memo.put(i+":"+j, max);
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "sadesf") + " " + count);
        System.out.println(lcsMemo("abcdef", "sadesf") + " " + count);
        System.out.println(lcs("abcdef", "bcde") + " " + count);
        System.out.println(lcsMemo("abcdef", "bcde") + " " + count);
        System.out.println(lcs("abc", "bde") + " " + count);
        System.out.println(lcsMemo("abc", "bde") + " " + count);
        System.out.println(lcs("abc", "efg") + " " + count);
        System.out.println(lcsMemo("abc", "efg") + " " + count);
    }

}
