package net.guhya.algo.array;

import java.util.Arrays;

public class ReverseArray {
	
	private static int count = 0;

	public static void reverse(int[] arr) {
		int len = arr.length;
		int lo = 0;
		int hi = len - 1;
		
		while (lo < hi) {
			int tmp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = tmp;
			lo++;
			hi--;
		}
	}
	

	public static void main(String[] args) {
		int[] arr = {2, 5, 6, 7};
		reverse(arr);
		System.out.println("Array : " + Arrays.toString(arr));
		System.out.println("Count : " + count);
	}

}
