package net.guhya.algo.sorting;

import net.guhya.algo.sorting.data.AbstractData;

public class InsertionSort extends AbstractData {
	
	@Override
	protected void sort(int[] arr) {
		boolean swap = false;
		int length = arr.length;
		/* Iterate from element 1 */
		for(int i=1; i<length; i++) {
			int j = i-1;
			int n = arr[i];
			while(j >= 0) {
				counter++;
				/* Compare with previous element */
				if(n < arr[j]) {
					/* 
					 * If previous element is bigger than current element, 
					 * move previous element to current element, get another
					 * previous element
					 */
					swap = true;
					arr[j+1] = arr[j];
					j--;
				}else {
					/* Previous element is not bigger, don't compare anymore */
					break;
				}
			}
			/* Put current element in it's place */
			if(swap) arr[j+1] = n;
		}
			
	}

	public InsertionSort() {
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
