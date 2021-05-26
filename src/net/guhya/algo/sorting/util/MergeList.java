package net.guhya.algo.sorting.util;

import java.util.Arrays;

public class MergeList {
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] <= arr2[j]) {
				result[k] = arr1[i];
				i++;
				k++;
			} else {
				result[k] = arr2[j];
				j++;
				k++;
			}
		}
		
		for(; i < arr1.length; i++) {
			result[k] = arr1[i];
			k++;
		}
		
		
		for(; j < arr2.length; j++) {
			result[k] = arr2[j];
			k++;
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {2, 4, 4, 6, 7};
		int[] arr2 = {1, 5, 9, 10, 11};
		
		System.out.println(Arrays.toString(merge(arr1, arr2)));
	}

}
