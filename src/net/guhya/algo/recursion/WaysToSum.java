package net.guhya.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToSum {

	private static int waysToSum(int[] arr, int sum) {
		
		System.out.println(Arrays.toString(arr));
		
		return helper(arr, arr.length, sum, new ArrayList<>());
	}
	
	private static int helper(int[] arr, int i, int sum, List<Integer> list) {
		if (sum == 0) {
			// We know the that this is the correct path
			System.out.println(list);
			return 1;
		}
		
		if (sum < 0) {
			return 0;
		}
		
		if (i <= 0 && sum > 0) {
			return 0;
		}
		
		// The coin will be excluded, will not be added to the used coin list
		int exclude = helper(arr, i-1, sum, list); 
		
		list.add(arr[i-1]);
		int include = helper(arr, i, sum - arr[i-1], list);
		
		int result = include + exclude;
		
		// Remove last coin when you go back up
		list.remove(list.size()-1);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2};
		int sum = 5;
		
		System.out.println(waysToSum(arr, sum));
	}

}
