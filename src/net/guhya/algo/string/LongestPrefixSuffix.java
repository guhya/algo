package net.guhya.algo.string;

import java.util.Arrays;

public class LongestPrefixSuffix {

    /**
     * Operation :
     *              - Slide to the right when match (meaning we found matching prefix and suffix)
     *              - Expand to the left when no match
     * The goal here is to find a longest prefix which also a suffix of a string.
     * We do this by using a sliding window technique.
     * If a character in lo match with character in hi, we slide window to the right.
     * If it doesn't match, we expand window to the left until zero.
     * @param str
     * @return
     */
    public static int[] lps(String str) {
        if (str == null) return new int[] {};
        
        int l = str.length();
        int[] lps = new int[l];
        int lo = 0;
        int hi = 1;
        lps[hi] = lo;
        while (hi < l) {
            if (str.charAt(lo) == str.charAt(hi)) {
                lo++;
                lps[hi] = lo;
                hi++;
            } else {
                if (lo == 0) {
                    lps[hi] = lo;
                    hi++;
                } else {
                    lo = lps[lo-1];
                }
            }
        }
        
        return lps;
    }

    public static void main(String[] args) {
        String str1 = "AAACAAAA";
        int[] lps1 = lps(str1);
        System.out.println(Arrays.toString(lps1));
        System.out.println("++++++");
        
        String str2 = "ABABBA";
        int[] lps2 = lps(str2);
        System.out.println(Arrays.toString(lps2));
    }

}
