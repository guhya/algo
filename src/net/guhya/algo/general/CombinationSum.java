package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    
    /**
     * When target is reached (equals to zero) combination is found
     * Remember that array list is mutable, so make sure to pass around a copy
     * Keep decreasing target until it's less or equal than zero
     * 
     * If we don't increase lo value, we will get list with same element but different order,
     * because our recursion will use lo again and again.
     * If we increase lo value before doing recursion, then we will never have two same element in the result array
     * If we increase lo after recursion, we wont have duplicate element in the result array
     * @param candidates
     * @param target
     * @param lo
     * @param hi
     * @param usedList
     * @param resultList
     */
	public static void combinationSumUtil(int[] candidates, int target, int lo, int hi, List<Integer> usedList, List<List<Integer>> resultList) {
		if (target < 0) return;
		if (target == 0) {
			resultList.add(usedList);
		}
		
		for (int i=lo; i<=hi; i++) {
			List<Integer> newUsedList = new ArrayList<>(usedList);
			newUsedList.add(candidates[i]);
			combinationSumUtil(candidates, target - candidates[i], lo, hi, newUsedList, resultList);
			// We increment lo here because we want to keep using this value until target is equal to or below zero
			lo = lo + 1;
		}
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		combinationSumUtil(candidates, target, 0, candidates.length-1, new ArrayList<Integer>(), resultList);
		return resultList;
    }
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 11;
		List<List<Integer>> result = combinationSum(candidates, target);
		for (List<Integer> r : result) {
		    System.out.println(r);
		}
	}
}
