package net.guhya.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedArray {

	public static int[] mergeMatrix(int[][] arr) {
		int[] result = new int[0];
		int m = 0;
		while (m < arr.length) {
			result = merge(result, arr[m]);
			m++;
		}
		
		return result;
	}
	
	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
			} else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		for (; i<arr1.length; i++) {
			result[k] = arr1[i];
			k++;
		}
		
		for (; j<arr2.length; j++) {
			result[k] = arr2[j];
			k++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int arr[][] = { 
				{1,  5,  6,  8 }, 
				{2,  4,  10, 12}, 
				{3,  7,  9,  11}, 
				{13, 14, 15, 16}
			};
		
		//int[] result = merge(arr[0], arr[1]);
		int[] result = mergeMatrix(arr);
		System.out.println(Arrays.toString(result));
		
		List<Integer> resultList = new ArrayList<Integer>(result.length);
		for (int i=0; i<result.length; i++) {
			resultList.add(result[i]);
		}
		
		
	}

}
