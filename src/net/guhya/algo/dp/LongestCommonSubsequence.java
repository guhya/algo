package net.guhya.algo.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
    public static int[] longestCommonSubsequence(int[] a, int[] b) {    	
    	/* Dynamic programming */
		System.out.print("\t");
    	for(int i=0; i<b.length; i++) {
    		System.out.print(b[i] + "\t");
    	}
		System.out.print("\n");

		int i = 0;
		int j = 0;
		int[][] m = new int[a.length][b.length];
    	for(i=0; i<m.length; i++) {
    		System.out.print(a[i] + "\t");
        	for(j=0; j<m[0].length; j++) {
        		int diagonal = (i-1 < 0 || j-1 < 0) ? 0 : m[i-1][j-1];
        		int previ = (i-1 < 0) ? 0 : m[i-1][j] ;
        		int prevj = (j-1 < 0) ? 0 : m[i][j-1] ;
        		if(a[i] == b[j]) {
        			m[i][j] = 1 + diagonal;
        		} else {
        			m[i][j] = Math.max(previ, prevj);
        		}
        		
        		System.out.print(m[i][j] + "\t");        		
        	}
    		System.out.print("\n");
    	}
    	i = i-1;
    	j = j-1;
    	
    	int longest = m[i][j];
    	System.out.println("Longest sequence ["+longest+"]");
    	
    	System.out.println("Output element");
    	int[] sequence = new int[longest];
    	while(j >= 0 && m[i][j] > 0) {
    		
    		int prevj = (j - 1 < 0) ? 0 : m[i][j-1];
    		if(m[i][j] != prevj) {
    			longest--;
    			sequence[longest] = b[j];
    			m[i][j] = m[i][j] * (-1);
    			j--;
    			i--;
    		}else {
    			j--;
    		}
    	}
    	
    	for(i=0; i<m.length; i++) {
    		System.out.print(a[i] + "\t");
        	for(j=0; j<m[0].length; j++) {
        		System.out.print(m[i][j] + "\t");        		
        	}
    		System.out.print("\n");
    	}
    	
    	
    	return sequence;
    }
	
    private static int LCS(int[] a, int[] b, int i, int j) {
    	if(i >= a.length || j >= b.length) {
    		return 0;
    	}
    	
    	if(a[i] == b[j]) {
    		return 1 + LCS(a, b, i+1, j+1);
    	}else {
    		return Math.max(LCS(a, b, i+1, j), LCS(a, b, i, j+1));
    	}
    }
    	
    
	public static void main(String[] args) {
		int[] a = {7, 2, 3, 4, 1};
		int[] b = {5, 4, 1, 2, 1, 3};
		
		int result[] = longestCommonSubsequence(a, b);
		System.out.println(Arrays.toString(result));
 	}
}
