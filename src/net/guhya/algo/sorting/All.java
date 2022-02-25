package net.guhya.algo.sorting;

import java.util.Arrays;

public class All {
	
	/**
	 * Just like when we sort playing cards
	 * @param arr, the array to be sorted
	 * @param l, starting element
	 * @param h, ending element
	 */
	public static void insertionSort(int[] arr, int l, int h) {
		for (int i=l+1; i<=h; i++) {
			int j = i;
			while (j > l) {
				if (arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
				} else {
					break;
				}
				j--;
			}
		}
	}

	/**
	 * Element is bubbling up, bigger element move to the last
	 * @param arr, the array to be sorted
	 * @param l, starting element
	 * @param h, ending element
	 */
	public static void bubbleSort(int[] arr, int l, int h) {
		for (int i=l; i<=h; i++) {
			boolean isSwap = false;
			for (int j=i+1; j<=h; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
					isSwap = true;
				}
			}
			if (!isSwap) return;
		}
	}
	
	/**
	 * Call partition multiple times on unsorted partition
	 * @param arr to be sorted
	 * @param l, starting index
	 * @param h, ending index
	 */
	public static void quickSort(int[] arr, int l, int h) {
		if (l >= h) return;
		
		int pivot = partition(arr, l, h);
		quickSort(arr, l, pivot-1);
		quickSort(arr, pivot+1, h);
	}
	
	/**
	 * The goal is all value smaller than pivot is on the left of pivot,
	 * the rest is on the right
	 * @param arr to be partitioned
	 * @param l, starting index
	 * @param h, ending index
	 * @return final pivot index
	 */
	public static int partition(int[] arr, int l, int h) {
		int pivot = l;
		int tmp = pivot + 1;
		for (int i=pivot+1; i<=h; i++) {
			if (arr[i] < arr[pivot]) {
				swap(arr, tmp, i);
				tmp++;
			}
		}
		tmp--;
		swap(arr, pivot, tmp);
		
		return tmp;
	}
	
	/**
	 * Given its index, swap array element
	 * @param arr
	 * @param i, first element
	 * @param j, second element
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * Divide array until it has one or zero element, and then
	 * merge those element back together
	 * @param arr
	 * @return
	 */
	public static int[] mergeSort(int[] arr) {
		int len = arr.length;
		if (len <= 1) return arr;
		
		int m = len / 2;
		int[] left = new int[m];
		for (int i=0; i<left.length; i++) {
			left[i] = arr[i];
		}
		
		int[] right = new int[len-m];
		for (int i=0; i<right.length; i++) {
			right[i] = arr[m+i];
		}
		
		int[] arrL = mergeSort(left);
		int[] arrR = mergeSort(right);
		int result[] = merge(arrL, arrR);
		
		return result;
	}
	
	/**
	 * Merge two arrays, sorted in ascending order
	 * @param arr1
	 * @param arr2
	 * @return merged sorted array
	 */
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
		
		while (i < arr1.length) {
			result[k] = arr1[i];
			i++;
			k++;
		}
		
		while (j < arr2.length) {
			result[k] = arr2[j];
			j++;
			k++;
		}
				
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {21, 1, 10, 80, 77, 20, 7, 22, 93, 30, 38, 82, 99, 43, 27};
		System.out.println(Arrays.toString(arr));
		//bubbleSort(arr, 0, arr.length-1);
		//insertionSort(arr, 0, arr.length-1);
		//partition(arr, 0, arr.length-1);
		//quickSort(arr, 0, arr.length-1);
		int[] result = mergeSort(arr);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(arr));
		
	}

}
