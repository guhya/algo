package net.guhya.algo.array;

public class FindPivot {
	
	private static int count = 0;

	private static int findPivot(int[] arr) {
		int len = arr.length;
		if (len == 0) return -1;
		if (len == 1) return -1;
		
		int pivot = -1;
		for(int i = 0; i < len-1; i++) {
			count++;
			if (arr[i] > arr[i + 1]) {
				pivot = i;
				break;
			}
		}
		
		if (pivot > -1) {
			for(int i = pivot+1; i < len-1; i++) {
				count++;
				if (arr[i] > arr[i + 1] || arr[i + 1] > arr[0]) {
					return -1;
				}
			}
		}
		
		return pivot;
		 
	}
	
	public static void main(String[] args) {
		int[] arr = {11, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Index   : " + findPivot(arr));
		System.out.println("Iterate : " + count);
	}

}
