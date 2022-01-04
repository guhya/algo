package net.guhya.algo.array;

public class BinarySearch {
	
	private static int count = 0;
	
	private static int binarySearch(int[] haystack, int lo, int hi, int needle) {
		count++;
		int len = haystack.length;
		if (len == 0) return -1;
		if (lo < 0) return -1;
		if (hi > len-1) return -1;
		if (lo > hi) return -1;
		
		if (haystack[lo] == needle) return lo;
		if (haystack[hi] == needle) return hi;
		
		int mid = (lo + hi) / 2;
		if (haystack[mid] == needle) return mid;
		if (haystack[mid] > needle) return binarySearch(haystack, 0, mid-1, needle);
		return binarySearch(haystack, mid+1, hi, needle);
	}
	
	public static void main(String[] args) {
		int[] haystack = {3, 4, 4, 6, 7, 9, 11, 12, 14, 15};
		int needle = 15;
		
		System.out.println("Index   : " + binarySearch(haystack, 0, haystack.length - 1, needle));
		System.out.println("Iterate : " + count);
	}
}
