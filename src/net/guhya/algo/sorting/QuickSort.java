package net.guhya.algo.sorting;

import net.guhya.algo.sorting.data.AbstractData;

public class QuickSort extends AbstractData {
	
	@Override
	protected void sort(int[] arr) {
		int len = arr.length;
		/* Copy array and add max value of int in the end for helper */
		int[] xarr = new int[len + 1];
		for(int i=0; i<len; i++) {
			xarr[i] = arr[i];
		}
		xarr[len] = Integer.MAX_VALUE;
		
		/* Use this new array to do sorting */
		partition(xarr, 0, len);
		
		/* Get back the original array */
		for(int i=0; i<len; i++) {
			arr[i] = xarr[i];
		}
	}
	
	private void partition(int xarr[], int lo, int hi) {
		/* Get length of original array */
		int len = hi;
		
		/* Always select first element as pivot */
		int pivot = lo;
		
		/* 
		 * We need low and high element to move to each other
		 * Select element after pivot as low element.
		 * High element is the original last element 
		 */
		lo = pivot + 1;		
		do {
			counter++;
			if(xarr[hi] < xarr[pivot]) {
				/* If hi element smaller than pivot */

				/* Swap hi and lo */
				int temp = xarr[lo];
				xarr[lo] = xarr[hi];
				xarr[hi] = temp;
				
				/* Make the element after lo as the new lo */
				lo++;
			} else {
				/* If hi element is not smaller than pivot,
				 * it means hi element is already in correct place,
				 * Select element before hi as the new hi */
				hi--;
			}
			
		/* Do this until lo and hi do not cross each other */
		} while (lo <= hi);
		
		/* When hi and lo cross each other, swap element at pivot with 
		 * element at hi (at this point all element in the left of pivot is
		 * smaller than pivot, and in the right is bigger than pivot) 
		 */
		int temp = xarr[pivot];
		xarr[pivot] = xarr[hi];
		xarr[hi] = temp;
		
		/* Sort right side (from first element to hi), 
		 * remember we didn't modify pivot value at all 
		 */
		if(hi > pivot) {
			partition(xarr, pivot, hi);
		}
		/* Sort right side, from lo (at this point, lo will always be hi+1) to len  */
		if(len > lo) {
			partition(xarr, lo, len);
		}
	}

	public QuickSort() {
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
