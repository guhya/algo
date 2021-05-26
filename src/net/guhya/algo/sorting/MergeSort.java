package net.guhya.algo.sorting;

import net.guhya.algo.sorting.data.AbstractData;
import net.guhya.algo.sorting.util.MergeList;

public class MergeSort extends AbstractData {

	@Override
	protected void sort(int[] arr) {
		int[] temp = mergeSort(arr);
		for(int i=0; i<=arr.length-1; i++) {
			arr[i] = temp[i];
		}
	}
	
	private int[] mergeSort(int[] arr) {
		counter++;
		if(0 >= (arr.length-1)) return arr;
		
		int mid = arr.length / 2;
		
		int[] arrLeft = new int[mid];
		for(int i=0; i<mid; i++) {
			arrLeft[i] = arr[i];
		}
		
		int[] arrRight = new int[arr.length-mid];
		for(int j=0; j<(arr.length-mid); j++) {
			arrRight[j] = arr[mid+j];
		}
		
		arrLeft = mergeSort(arrLeft);
		arrRight = mergeSort(arrRight);
		counter += (arrLeft.length + arrRight.length);
		arr = MergeList.merge(arrLeft, arrRight);

		return arr;
	}
	
	public MergeSort() {
		counter = 0;
		int[] arr = normalArrayFixed;
		printArray(arr);
		sort(arr);
		printArray(arr);
		System.out.println("Counter ["+counter+"]");

		counter = 0;
		arr = normalArrayRandom;
		printArray(arr);
		sort(arr);
		printArray(arr);
		System.out.println("Counter ["+counter+"]");

		counter = 0;
		arr = sortedArrayAsc;
		printArray(arr);
		sort(arr);
		printArray(arr);
		System.out.println("Counter ["+counter+"]");

		counter = 0;
		arr = sortedArrayDesc;
		printArray(arr);
		sort(arr);
		printArray(arr);
		System.out.println("Counter ["+counter+"]");
	}	
	
}
