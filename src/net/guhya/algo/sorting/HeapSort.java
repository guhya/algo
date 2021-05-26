package net.guhya.algo.sorting;

import net.guhya.algo.sorting.data.AbstractData;
import net.guhya.algo.sorting.util.Heap;

public class HeapSort extends AbstractData {

	protected int[] heapSort(int[] arr) {
		int len = arr.length;
		for(int i=1; i<len; i++) {
			counter++;
			int h = len-i;

			//Swap root and last element
			int temp = arr[0];
			arr[0] = arr[h];
			arr[h] = temp;
			

			//Adjust root
			int parentIndex = 0;
			while(h > parentIndex) {
				counter++;
				int leftChildIndex = (parentIndex + 1) * 2 - 1;  
				int rightChildIndex = (parentIndex + 1) * 2;
				
				if(leftChildIndex >= h || rightChildIndex >= h) {
					break;
				}
				
				
				//Compare with the left and right child
				if(arr[parentIndex] < arr[leftChildIndex] 
						|| arr[parentIndex] < arr[rightChildIndex]) {
					
					if(arr[leftChildIndex] >= arr[rightChildIndex]){
						int tmp = arr[parentIndex];
						arr[parentIndex] = arr[leftChildIndex];
						arr[leftChildIndex] = tmp;
						parentIndex = leftChildIndex;
					}else { 
						int tmp = arr[parentIndex];
						arr[parentIndex] = arr[rightChildIndex];
						arr[rightChildIndex] = tmp;
						parentIndex = rightChildIndex;
					} 
				} else {
					break;
				}
				
			}
		}
		if(arr[0] > arr[1]){
			int temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		
		return arr;
	}
	
	@Override
	protected void sort(int[] arr) {
		int[] result = Heap.heapify(arr);
		result = heapSort(result);
		for(int i=0; i<result.length; i++) {
			arr[i] = result[i];
		}
	}
	
	public HeapSort() {
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
