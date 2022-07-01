package net.guhya.algo.general;

public class LongestCommonSubstring {

    private static int lcs(String a1, String a2) {
        return lcsHelper(a1, a2, a1.length()-1, a2.length()-1, 0);
    }

    private static int lcsHelper(String a1, String a2, int i, int j, int count) {
        if (i < 0 || j < 0) return count;
        
        if (a1.charAt(i) == a2.charAt(j)) {
            count = lcsHelper(a1, a2, i-1, j-1, count + 1);
        } 
        
        int maxi = lcsHelper(a1, a2, i-1, j, 0);
        int maxj = lcsHelper(a1, a2, i, j-1, 0);
        int max = Math.max(maxi, maxj);
        
        return Math.max(count, max);
    }
    
    private static int lcsHelper(String a1, String a2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        
        int count = 0;
        if (a1.charAt(i) == a2.charAt(j)) {
            count = 1 + lcsHelper(a1, a2, i-1, j-1);
        } else {
            return 0;
        }
        
        int maxi = lcsHelper(a1, a2, i-1, j);
        int maxj = lcsHelper(a1, a2, i, j-1);
        int max = Math.max(maxi, maxj);
        
        return Math.max(count, max);
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "abcfgh"));
        System.out.println(lcs("abcdef", "sadesf"));
        System.out.println(lcs("abcdef", "bcde"));
    }

}
