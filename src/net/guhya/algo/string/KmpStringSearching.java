package net.guhya.algo.string;

public class KmpStringSearching {

    /**
     * Resetting both pointer at mismatch which is very inefficient
     * @param haystack
     * @param needle
     * @return
     */
    private static int naiveSearch(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        
        int counter = 0;
        for (int i=0; i<haystack.length(); i++) {
            int j = 0;
            for (; j<needle.length(); j++) {
                counter++;
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                System.out.print(counter + " -> ");
                return i;
            }
            
            // If code reaches here, then it is a mismatch, reset both i and j to 0
        }
        
        return -1;
    }
    
    /**
     * Instead of going back and reset pointers to 0 like naive algorithm, we go back at common prefix
     * @param haystack
     * @param needle
     * @return
     */
    private static int kmpSearch(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        
        // Value at lps[i] means at that length i, needle has x longest common prefix and suffix
        int lps[] = LongestPrefixSuffix.lps(needle);
        int counter = 0;
        int j = 0;
        for (int i=0; i<haystack.length(); i++) {
            for (; j<needle.length(); j++) {
                counter++;
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == needle.length()) {
                System.out.print(counter + " -> ");
                return i;
            }
            
            // If code reaches here, then it is a mismatch we will NOT reset both i and j to 0
            // Check if j is not 0 (partial match) then set i as i + partial match length minus lps value
            if (j != 0) {
                // We do not let i go back, so we increase i with j minus lps value
                i = i + j - lps[j-1]; 
                
                // We do not reset j to zero
                j = lps[j-1];
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        String haystack1 = "AAAAAAC";
        String needle1 = "AAC";
        System.out.println(naiveSearch(haystack1, needle1));
        System.out.println(kmpSearch(haystack1, needle1));
    }

}
