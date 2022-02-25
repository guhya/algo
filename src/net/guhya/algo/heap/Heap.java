package net.guhya.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Heap {

	public static void maxHeap(int[] arr, int rootIdx, int l) {	
		for(int i=l/2-1; i>=0; i--) {
			int lIdx = i*2+1;
			int rIdx = i*2+2;
			
			if (arr[i] < arr[lIdx]) {
				int temp = arr[i];
				arr[i] = arr[lIdx];
				arr[lIdx] = temp;
			}
			
			if (rIdx < l && arr[i] < arr[rIdx]) {
				int temp = arr[i];
				arr[i] = arr[rIdx];
				arr[rIdx] = temp;
			}
			
			if (i > rootIdx) maxHeap(arr, i, l);
		}
	}
	
	public static void heapSort(int[] arr) {
		int l = arr.length;
		for (int i=l; i>0; i--) {
			maxHeap(arr, 0, i);
			int temp = arr[0];
			arr[0] = arr[i-1];
			arr[i-1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 8, 7, 4, 70, 60, 50};
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
		
		int k = 3;
		int ptrArray[] = new int[k];
		for (int i = 0; i < k; i++) {
			System.out.println(ptrArray[i]);
		}

		LinkedList<Integer> q = new LinkedList<>();
		q.add(7);
		System.out.println(q.removeFirst());
		System.out.println(q);
	}
	
}
