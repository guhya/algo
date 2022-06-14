package net.guhya.algo.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"abcdefg", "abcgg", "abcde", "a"};
        int lcp = longest(strs);
        System.out.println(lcp);
    }

    private static int longest(String[] strs) {
        if (strs.length <= 1) return 0;
        
        int i = 0;
        while (i < strs[0].length()) {
            for (int j=1; j<strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return i;
                }
            }
            i++;
        }
        
        return i;
    }

}
