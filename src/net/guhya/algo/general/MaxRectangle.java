package net.guhya.algo.general;

import java.util.LinkedList;

public class MaxRectangle {
	
	public static int[] buildHistogram(char[][] matrix, int row) {
		int[] histogram = new int[matrix[0].length];
		for (int i=0; i<matrix[0].length; i++) {
			int tRow = row;
			while (tRow >= 0 && matrix[tRow][i] == '1') {
				histogram[i]++;
				tRow--;
			}
		}
		
		return histogram;
	}
	
	private static int largestRectangleAreaHistogram(int[] histogram) {
        if (histogram.length == 1) return histogram[0];
		LinkedList<Integer> stack = new LinkedList<>();
		int max = 0;
		for (int i=0; i<=histogram.length; i++) {
			int current = i == histogram.length ? 0 : histogram[i];
			while (!stack.isEmpty()) {				
				int top = stack.peekLast();
				if (current < histogram[top]) {
					int height = histogram[stack.removeLast()];
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
	
    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        
        for (int i=0; i<matrix.length; i++) {
        	int histogramMaxArea = largestRectangleAreaHistogram(buildHistogram(matrix, i));
        	max = Math.max(max, histogramMaxArea);
        }
        
        return max;
    }
	

	public static void main(String[] args) {
		char[][] matrix1 = {
					         {'1', '1', '0', '1', '1', '0', '1'},
					         {'0', '1', '0', '1', '1', '0', '1'},
					         {'1', '1', '1', '1', '1', '1', '1'},
					         {'1', '1', '1', '1', '1', '1', '1'},
					         {'1', '1', '1', '1', '1', '1', '1'}
						 };
		System.out.println(maximalRectangle(matrix1));
	}

}
