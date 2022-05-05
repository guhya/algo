package net.guhya.algo.general;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
    	if (prices.length == 1) return 0;
    	int lo = 0, hi = 1;
    	int max = 0;
    	while (hi < prices.length) {
    		if (prices[hi] < prices[lo]) {
    			lo = hi;
    		} else {
    			max = Math.max(max, prices[hi] - prices[lo]);
    		}
			hi++;
    	}
    	
    	return max;
    }
	
	public static void main(String[] args) {
		int[] prices1 = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices1));
		System.out.println("+++++++++++");
		int[] prices2 = {7,6,4,3,1};
		System.out.println(maxProfit(prices2));
		System.out.println("+++++++++++");
		int[] prices3 = {1};
		System.out.println(maxProfit(prices3));
		System.out.println("+++++++++++");
		int[] prices4 = {1,4,2};
		System.out.println(maxProfit(prices4));
		System.out.println("+++++++++++");
		int[] prices5 = {3,2,6,5,0,3};
		System.out.println(maxProfit(prices5));
	}

}
