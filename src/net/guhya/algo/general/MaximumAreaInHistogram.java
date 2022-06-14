package net.guhya.algo.general;

import java.util.LinkedList;

public class MaximumAreaInHistogram {

    /**
     * Operation :
     *              - Look left, decrease i
     *              - Look right, increase i
     * Brute force approach, basically we know the height which is element on position i.
     * To find the width, we move to the left (i--) and to the right (i++) until we find
     * and element which is less than the height at element i.
     * @param heights histogram
     * @return max square
     */
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
	
	/**
	 * What we put in the stack is the position (index). Since only with position we can calculate
	 * width of the area.
	 * Operation :
	 *             - Pushing element to stack if value is increasing, increasing i (hi) boundary
	 *             - Popping element from stack, seeking lo boundary
	 * We know the height which is element on position i, same as brute force approach.
	 * Now basically we still do the same, moving to the left and to the right to find lower height.
	 * But we can save this visited height (all heights on the left) in a stack in increasing order,
	 * we do this by only pushing an element if it is higher than the element at the top of the stack.
	 * The width now become, the position of top element in the stack until current i 
	 * (we know for sure this is lower than top of the stack)
	 * @param heights
	 * @return
	 */
	private static int largestRectangleAreaStack(int[] heights) {
        if (heights.length == 1) return heights[0];
		LinkedList<Integer> stack = new LinkedList<>();
		int max = 0;
		for (int i=0; i<heights.length; i++) {
		    // We iterate until the value after the last because this is the right boundary
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
