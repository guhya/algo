package net.guhya.algo.general;

public class ClimbingStairs {
	
	public static int climbStairsUtil(int n, int[] memo) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		if (memo[n] > 0) return memo[n];
		
		int oneStep = climbStairsUtil(n-1, memo);
		int twoStep = climbStairsUtil(n-2, memo);
		memo[n] = oneStep + twoStep;
		
		return oneStep + twoStep;
	}
	
    public static int climbStairs(int n) {
    	int[] memo = new int[n+1];
        return climbStairsUtil(n, memo);
    }
    
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println("++++++++++");
		System.out.println(climbStairs(2));
		System.out.println("++++++++++");
		System.out.println(climbStairs(3));
		System.out.println("++++++++++");
		System.out.println(climbStairs(4));
		System.out.println("++++++++++");
		System.out.println(climbStairs(45));
	}

}
