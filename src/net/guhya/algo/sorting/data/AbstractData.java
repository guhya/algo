package net.guhya.algo.sorting.data;

import java.util.Arrays;

public abstract class AbstractData {

	private static final int ARRAY_SIZE = 256;
	protected long counter = 0;
	protected int[] normalArrayRandom = new int[ARRAY_SIZE];
	protected int[] sortedArrayAsc = new int[ARRAY_SIZE];
	protected int[] sortedArrayDesc = new int[ARRAY_SIZE];
	
	protected int[] normalArrayFixed = {20, 9, 3, 8, 7, 24, 90, 22, 1, 5, 
										8, 19, 11, 34, 33, 40, 13, 21, 32, 60,
										27, 46, 88, 12};

	public AbstractData() {
		counter = 0;
		for(int i=0; i<ARRAY_SIZE; i++) {
			int a = (int) (Math.random() * (100+ARRAY_SIZE));
			normalArrayRandom[i] = a;
			sortedArrayAsc[i] = i;
			sortedArrayDesc[i] = ARRAY_SIZE-i;
		}
	}
	
	protected static void printArray (int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	protected abstract void sort(int[] arr);
	
}
