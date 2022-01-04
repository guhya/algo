package net.guhya.algo.array;

import java.util.Arrays;

public class TwoSum {
	
	private static int count = 0;
	
	private static int[] pairSum(int[] arr, int sum) {
		int len = arr.length;
		if (len < 2) return new int[] {};
		
		int tmp = 0;
		int lo = 0;
		int hi = len - 1;
		
		while (lo != hi) {
			count++;
			tmp = arr[lo] + arr[hi];
			System.out.println(arr[lo] + " + " + arr[hi] + " = " + tmp);
			if (tmp == sum) return new int[] {arr[lo], arr[hi]};
			if (tmp < sum) { 
				lo++;
			} else {
				hi--;
			}
		}
		
		return new int[] {};
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 6, 7, 12, 15, 22, 23};
		int sum = 19;
		
		System.out.println("Array : " + Arrays.toString(pairSum(arr, sum)));
		System.out.println("Count : " + count);
	}
}
