package net.guhya.algo.dp;

import java.util.Arrays;

public class Fibonacci {

	public static void fib(int target) {
		int[] temp = new int[target+1];
		for(int i=0; i<=target; i++) {
			if(i==0) {
				temp[i] = 0;
			} else if(i==1) {
				temp[i] = 1;
			} else {
				temp[i] = temp[i-1] + temp[i-2];
			}
		}
		
		System.out.println("Fibonacci seq "+Arrays.toString(temp));
	}
	
	public static void main(String[] args) {
		fib(32);
	}

}
