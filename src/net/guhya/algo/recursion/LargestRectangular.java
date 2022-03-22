package net.guhya.algo.recursion;

public class LargestRectangular {

	public static int getMaxArea(int[] arr, int lo, int hi, int size) {
		int minIndex = minIndex(arr, lo, hi);
		int maxLeft = 0, center = 0, maxRight = 0;
		
		center = arr[minIndex] * size;
		if (lo < minIndex) {
			maxLeft = getMaxArea(arr, lo, minIndex-1, minIndex-lo);
		}
		
		if (hi > minIndex) {
			maxRight = getMaxArea(arr, minIndex+1, hi, hi-minIndex);
		}
		
		return Math.max(center, Math.max(maxLeft, maxRight));
	}
	
	public static int minIndex(int[] arr, int lo, int hi) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i=lo; i<=hi; i++) {
			if (arr[i] < min) {
				idx = i;
				min = arr[i];
			}
		}
		
		return idx;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 1, 4, 5, 1, 3, 3};
		int maxArea = getMaxArea(arr, 0, arr.length-1, arr.length);

		System.out.println(maxArea);
	}

}
