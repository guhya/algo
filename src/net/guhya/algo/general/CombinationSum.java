package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    
	public static void combinationSumUtil(int[] candidates, int target, int lo, int hi, List<Integer> usedList, List<List<Integer>> resultList) {
		if (target < 0) return;
		if (target == 0) {
			resultList.add(usedList);
		}
		
		for (int i=lo; i<=hi; i++) {
			List<Integer> newUsedList = new ArrayList<>(usedList);
			newUsedList.add(candidates[i]);
			combinationSumUtil(candidates, target - candidates[i], lo, hi, newUsedList, resultList);
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
		int target = 7;
		List<List<Integer>> result = combinationSum(candidates, target);
		for (List<Integer> r : result) {
		    System.out.println(r);
		}
	}
}
