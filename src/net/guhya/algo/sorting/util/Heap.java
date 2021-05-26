package net.guhya.algo.sorting.util;

import java.util.Arrays;

public class Heap {

	public static int[] heapify(int[] arr) {
		int[] result = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			int val = arr[i];
			result[i] = val;
			if(i > 0) {
				int p = i;
				while (p > 0) {
					if(result[p] > result[((p + 1) / 2) - 1]) {
						int temp = result[p]; 
						result[p] = result[((p + 1) / 2) - 1];
						result[((p + 1) / 2) - 1] = temp;
						p = ((p + 1) / 2) - 1;
					} else {
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 9, 3, 8, 7, 24, 90, 22, 1, 5};
		arr = heapify(arr);
		System.out.println(Arrays.toString(arr));
	}

}
