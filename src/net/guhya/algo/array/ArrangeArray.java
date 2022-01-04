package net.guhya.algo.array;

import java.util.Arrays;

public class ArrangeArray {
	
	private static int count = 0;

	
	private static void arrange(int[] arr) {
		int len = arr.length;
		
		int c = 0;
		while (c < (len-1)) {
			count++;
			if (arr[c] >= 0 && arr[c] != c) {
				int tmp = arr[arr[c]];
				arr[arr[c]] = arr[c];
				arr[c] = tmp;
			} else {
				c++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		
		arrange(arr);
		System.out.println("Index   : " + Arrays.toString(arr));
		System.out.println("Iterate : " + count);
	}

}
