package net.guhya.algo.string;

import java.util.Arrays;

public class StringReversal {

	public static void main(String[] args) {

		String normal = "guhya eka wijaya adalah orang yang hebat";
		int len = normal.length();
		int lo = 0;
		int hi = len - 1;
		
		char[] rev = new char[len];
		while (lo <= hi) {
			rev[lo] = normal.charAt(hi);
			rev[hi] = normal.charAt(lo);
			lo++;
			hi--;
		}
		
		StringBuilder sb = new StringBuilder();
		hi = len - 1;    
		while (hi >= 0) {
			sb.append(normal.charAt(hi));
			hi--;
		}
		
		System.out.println(Arrays.toString(rev));
		System.out.println(sb.toString());
		
		System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
		int x = Integer.MAX_VALUE;
		long y = Integer.MAX_VALUE;
		
		System.out.println(x + 2);
		System.out.println(y + 2);
	}

}
