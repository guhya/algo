package net.guhya.algo.general;

import java.util.LinkedList;

public class MaximumAreaInHistogram {

	private static int largestRectangleAreaBrute(int[] heights) {
		int max = Integer.MIN_VALUE;
		for (int i=0; i<heights.length; i++) {
			int area = heights[i] * getWidth(heights, i);
			max = Math.max(area, max);
		}
		
		return max;
	}
	
	private static int getWidth(int[] heights, int idx) {
		int lo = idx, hi = idx;
		while (lo >= 0 && heights[idx] <= heights[lo]) {
			lo--;
		}
		
		while (hi < heights.length && heights[idx] <= heights[hi]) {
			hi++;
		}
		
		return hi-lo-1;
	}
	
	private static int largestRectangleAreaStack(int[] heights) {
        if (heights.length == 1) return heights[0];
		LinkedList<Integer> stack = new LinkedList<>();
		int max = 0;
		for (int i=0; i<=heights.length; i++) {
			int current = i == heights.length ? 0 : heights[i];
			while (!stack.isEmpty()) {				
				int top = stack.peekLast();
				if (current < heights[top]) {
					int height = heights[stack.removeLast()];
					int hi = i;
					// When stack is empty, then so far this value is the smallest height
					// Smallest height always has the full length as width
					int lo = stack.isEmpty() ? -1 : stack.peekLast();
					int width = hi-lo-1;
					int area = height * width;
					max = Math.max(area, max);
				} else {
					break;
				}
			}
			stack.add(i);
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] heights1 = {2,1,5,6,2,3};
		System.out.println(largestRectangleAreaBrute(heights1));
		System.out.println(largestRectangleAreaStack(heights1));
		System.out.println("++++++++++");
		int[] heights2 = {4,2,0,3,2,5};
		System.out.println(largestRectangleAreaBrute(heights2));
		System.out.println(largestRectangleAreaStack(heights2));
	}

}
