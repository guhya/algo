	package net.guhya.algo.dp;

import java.util.ArrayList;
import java.util.List;

public class MinimumToSum {

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
			
			/* When sum is 0, we say that the minimum way is 1 */
			temp[i][0] = 1;
			for(int j=0; j<=sum; j++) {
				if(i==0) {
					/* First time, simply count how much is j*/
					temp[i][j] = j; 
				}else {
					/* Get previous ways using previous coins, add this to :
					 * Subtract sum with coin, and take the reminder index 
					 * If remainder index is less than 0, then we ignore value
					 * otherwise we get the value of that index and add this 
					 * */
					int r = (j-coinList[i]);
					if(r < 0) {
						temp[i][j] = temp[i-1][j];
					}else {
						/* This is previous value */
						int prev = temp[i-1][j];
						
						/* Minimum between previous value, and (current value
						 * minus coin, plus the reminder value)
						 */
						int current = 1 + temp[i][r];
						temp[i][j] = Math.min(prev, current);
					}
				}
				System.out.print("\t" + temp[i][j]);
			}
		}
		
		/* Find out the coin combination */
		int i = len-1;
		int j = sum;
		List<Integer> combinations = new ArrayList<Integer>(); 
		while(j > 0) {
			/* If value with previous is same, it means it is spill over */
 			if(i > 0 && temp[i][j] == temp[i-1][j]) {
				i--;
			} else {
				combinations.add(coinList[i]);
				j = j-coinList[i];
			}
		}
		System.out.println("\nMinimum combination " + combinations);
		
		return temp[len-1][sum];
	}
	
	public static void main(String[] args) {
		int ways = getWays(new int[]{1, 2, 5, 10}, 13); 
		System.out.println("\nMinimum coins to make sum [" + ways + "]");
	}

}
