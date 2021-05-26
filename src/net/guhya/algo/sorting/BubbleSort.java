package net.guhya.algo.sorting;

import net.guhya.algo.sorting.data.AbstractData;

public class BubbleSort extends AbstractData {
	
	@Override
	protected void sort(int[] arr) {
		int length = arr.length;
		/* Iterate from first element until the end */
		for(int i=0; i<length; i++) {
			boolean swap = false;
			/* Compare with the next element */
			for(int j=i+1; j<length; j++) {
				counter++;
				/* If next element is bigger than current, swap it */
				if(arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					swap = true;
				}
			}
			
			/* If there is no swap detected, that means all is sorted, ends */
			if(!swap) return;
		}
			
	}

	public BubbleSort() {
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
