package net.guhya.algo.general;

public class UniquePaths {

    public static int uniquePathsUtil(int row, int col, int[][] memo) {
        if (row == 0 && col == 0) {
        	return 1;
        }
        
        if (row < 0 || col < 0) {
        	return 0;
        }
        
        if (memo[row][col] > 0) {
        	return memo[row][col];
        }
        
        int down = uniquePathsUtil(row-1, col, memo);
        int right = uniquePathsUtil(row, col-1, memo);
        memo[row][col] = down + right;
        
        return down + right;
    }
	
    public static int uniquePaths(int m, int n) {
    	int[][] memo = new int[m][n];
    	int path = uniquePathsUtil(m-1, n-1, memo);
        return path;
    }

	
	public static void main(String[] args) {
		int m = 3, n = 7;
		System.out.println(uniquePaths(m, n));
	}

}
