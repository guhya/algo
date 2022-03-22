package net.guhya.algo.graph;

import java.util.Arrays;

public class TreeHeightFromParent {

	
	public static void getHeight(int[] arr, int[] level, int idx) {
		for (int i=idx+1; i<arr.length; i++) {
			if (arr[i] == idx) {
				level[i] = level[idx] + 1;
				getHeight(arr, level, i);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] parent = {-1, 0, 1, 2, 3};
		int[] level = new int[parent.length];
		
		getHeight(parent, level, 0);
		System.out.println(Arrays.toString(level));
	}

}
