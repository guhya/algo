package net.guhya.algo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
    	Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) return 1;
				if (o1[0] < o2[0]) return -1;
				return 0;
			}
		});
    	
    	LinkedList<int[]> stack = new LinkedList<>();
    	stack.push(intervals[0]);
    	for (int i=1; i<intervals.length; i++) {
    		int end = stack.peek()[1];
    		if (intervals[i][0] <= end) {
    			stack.peek()[1] = Math.max(intervals[i][1], end);
    		} else {
    			stack.push(intervals[i]);
    		}
    	}
    	
    	int s = stack.size();
    	int[][] result = new int[s][2];
    	for (int i=0; i<s; i++) {
    		int[] arr = stack.removeLast();
    		result[i][0] = arr[0];
    		result[i][1] = arr[1];
    	}
    	
        return result;
    }	
	
	public static void main(String[] args) {
		int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(Arrays.deepToString(merge(intervals1)));
		
		int[][] intervals2 = {{1,4},{2,3}};
		System.out.println(Arrays.deepToString(merge(intervals2)));
	}

}
