package net.guhya.algo.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class OverlappingInterval {

	public static class Interval {
		public int start;
		public int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return String.valueOf("[" + start + ", " + end + "]");
		}
	}
	
	private static void mergeIntervals(Interval[] arr) {
		Arrays.sort(arr, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		LinkedList<Interval> stack = new LinkedList<>();
		stack.push(arr[0]);
		for(int i=1; i<arr.length; i++) {
			Interval top = stack.peek();
			if (arr[i].start > top.end) {
				stack.push(arr[i]);
			} else {
				if (arr[i].end > top.end) {
					Interval tmp = stack.pop();
					tmp.end = arr[i].end;
					stack.push(tmp);
				}
			}
		}
		
		
		System.out.println(stack);
	}
	
	public static void main(String[] args) {
        Interval[] arr = new Interval[4];
        arr[0] = new Interval(1, 9);
        arr[1] = new Interval(2, 4);
        arr[2] = new Interval(3, 6);
        arr[3] = new Interval(10, 15);
        
        mergeIntervals(arr);
	}


}
