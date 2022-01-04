package net.guhya.algo.array;

import java.util.Arrays;

public class RotateArray {
	
	private static int count = 0;

	public static void rotate(int[] arr, int n) {
		int len = arr.length;
		
		int c = 1;
		while (c <= n) {
			int tmp = arr[0];
			for(int i=0; i<(len-1); i++) {
				count++;
				arr[i] = arr[i + 1];
			}
			arr[len - 1] = tmp;
			c++;
		}
	}
	
	public static void swapRotate(int[] arr, int n) {
		int len = arr.length;
		
		int tmp[] = new int[len];
		for (int i = 0; i<len; i++) {
			count++;
			tmp[i] = arr[i];
		}
		
		n = n % len;
		for (int i = n; i<len; i++) {
			count++;
			arr[i-n] = tmp[i];
		}
		
		for (int i = 0; i<n; i++) {
			count++;
			arr[len-n+i] = tmp[i];
		}
		
	}
	
	public static void main(String[] args) {
		int n = 10;

		int[] arr1 = {2, 5, 6, 7, 12, 15, 22, 23};
		rotate(arr1, n);
		System.out.println("Array : " + Arrays.toString(arr1));
		System.out.println("Count : " + count);
		
		int[] arr2 = {2, 5, 6, 7, 12, 15, 22, 23};
		count = 0;
		swapRotate(arr2, n);
		System.out.println("Array : " + Arrays.toString(arr2));
		System.out.println("Count : " + count);
	}

}
