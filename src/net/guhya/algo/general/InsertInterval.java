package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
    	LinkedList<int[]> stack = new LinkedList<>();
    	if (intervals.length == 0 || intervals[0].length == 0) {
    		stack.add(newInterval);
    	} else {    	
	    	int[][] combinedIntervals = new int[intervals.length+1][2];
	    	int i = 0, j = 0, k = 0;
	    	while (i < intervals.length && j < 1) {
	    		if (intervals[i][0] < newInterval[0]) {
	        		combinedIntervals[k] = intervals[i];
	        		i++;
	    		} else {
	        		combinedIntervals[k] = newInterval;
	        		j++;
	    		}
	    		k++;
	    	}
	    	
	    	while (i < intervals.length) {
	    		combinedIntervals[k] = intervals[i];
	    		i++;
	    		k++;
	    	}
	    	
	    	while (j < 1) {
	    		combinedIntervals[k] = newInterval;
	    		j++;
	    		k++;
	    	}
    	
	    	stack.push(combinedIntervals[0]);
	    	for (i=1; i<combinedIntervals.length; i++) {
	    		int end = stack.peek()[1];
	    		if (combinedIntervals[i][0] <= end) {
	    			stack.peek()[1] = Math.max(combinedIntervals[i][1], end);
	    		} else {
	    			stack.push(combinedIntervals[i]);
	    		}
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
    
    public static int[][] insertLinear(int[][] intervals, int[] newInterval) {
    	
    	int i = 0;
    	int l = intervals.length;
    	List<int[]> resultList = new ArrayList<>();
    	if (intervals.length > 0) {
	    	while (i < l && newInterval[0] > intervals[i][1]) {
	    		resultList.add(intervals[i]);
	    		i++;
	    	}
	    	
	    	while (i < l && newInterval[1] >= intervals[i][0]) {
	    		newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
	    		newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
	    		i++;
	    	}
			resultList.add(newInterval);
			
			while (i < l) {
				resultList.add(intervals[i]);
				i++;
			}
    	} else {
			resultList.add(newInterval);
    	}
    	
    	int[][] resultArr = new int[resultList.size()][2];
    	for (i=0; i<resultList.size(); i++) {
    		resultArr[i] = resultList.get(i);
    	}
    	
    	return resultArr;
    }
    
	public static void main(String[] args) {
		int[][] intervals1 = {{1,3},{6,9}};
		int[] newInterval1 = {2,5};
		System.out.println(Arrays.deepToString(insertLinear(intervals1, newInterval1)));
		
		System.out.println("++++++++++");
		int[][] intervals2 = {};
		int[] newInterval2 = {2,5};
		System.out.println(Arrays.deepToString(insertLinear(intervals2, newInterval2)));
		
		System.out.println("++++++++++");
		int[][] intervals3 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval3 = {4,8};
		System.out.println(Arrays.deepToString(insertLinear(intervals3, newInterval3)));
	}

}
