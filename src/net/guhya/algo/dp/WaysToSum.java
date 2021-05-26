	package net.guhya.algo.dp;

public class WaysToSum {

	private static int getWays(int[] coinList, int sum) {
		
		System.out.print("Sum\t");
		for(int i=0; i<=sum; i++) {
			System.out.print("\t" + i);
		}
		int len = coinList.length;
		int[][] temp = new int[len][sum+1];
		for(int i=0; i<len; i++) {
			/* If coin is greater than sum, no need to compute, exit early*/
			if (coinList[i] > sum) {
				return temp[i-1][sum];
			}
			System.out.print("\nCoin ["+coinList[i]+"]");
			
			/* When sum is 0, we say that the possible way is 1 */
			temp[i][0] = 1;
			for(int j=0; j<=sum; j++) {
				if(i==0) {
					/* First time, compute if sum is divisible by first coin */
					temp[i][j] = (j % coinList[0] == 0) ? 1 : 0; 
				}else {
					/* Get previous ways using previous coins, add this 
					 * Subtract sum with coin, and take the reminder index 
					 * If remainder index is less than 0, then we ignore value
					 * otherwise we get the value of that index and add this*/
					int r = (j-coinList[i]);
					if(r < 0) {
						temp[i][j] = temp[i-1][j];
					}else {
						temp[i][j] = temp[i-1][j] + temp[i][r];
					}
				}
				System.out.print("\t" + temp[i][j]);
			}
		}
		
		return temp[len-1][sum];
	}
	
	public static void main(String[] args) {
		int ways = getWays(new int[]{1, 2, 5, 10, 20, 50, 100}, 10); 
		System.out.println("\nTotal ways to make sum [" + ways + "]");
	}

}
