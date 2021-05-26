package net.guhya.algo.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoinChanges {

static int counter = 0;
	
	public static Set<List<Integer>> change(int[] arr, int sum) {
		List<Integer> coinList = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			coinList.add(arr[i]);
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result =  recurse(new ArrayList<Integer>(), coinList, sum, result);
		Set<List<Integer>> cleanResult = new HashSet<>(result);
		
		return cleanResult;
	}
	
	private static List<List<Integer>> recurse(List<Integer> holder
			, List<Integer> coinList, int sum, List<List<Integer>> result) {
		
		counter++;
		
		if(sum == 0) {
			System.out.println(holder);
			List<Integer> sortedHolder = new ArrayList<>(holder);
			Collections.sort(sortedHolder);
			result.add(sortedHolder);
			return result;
			
		} else if(sum < 0){
			return result;
		}
		
		int i = 0;
		while(i < coinList.size()) {
			int coin = coinList.get(i);
			int newSum = sum - coin;
			holder.add(coin);
			//System.out.println("Holder "+holder+" coin ["+coin+"] = ["+newSum+"]");
			if(newSum >= 0) {
				recurse(holder, coinList, newSum, result);
			}
			holder.remove(holder.size()-1);
			i++;
		}
		
		return result;
		
	}
	
	public static Set<List<Integer>> changeAndMemoize(int[] arr, int sum) {
		List<Integer> coinList = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			coinList.add(arr[i]);
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result =  recurseAndMemoize(new ArrayList<Integer>(), coinList, sum, result
				, new HashMap<Integer, List<Integer>>());
		
		Set<List<Integer>> cleanResult = new HashSet<>(result);
		
		return cleanResult;
	}
	
	
	private static List<List<Integer>> recurseAndMemoize(List<Integer> holder
			, List<Integer> coinList, int sum, List<List<Integer>> result
			, Map<Integer, List<Integer>> cache) {
		
		counter++;
		
		if(sum == 0) {
			System.out.println(holder);
			List<Integer> sortedHolder = new ArrayList<>(holder);
			Collections.sort(sortedHolder);
			result.add(sortedHolder);
			return result;
			
		} else if(sum < 0){
			return result;
		}
		
		int i = 0;
		while(i < coinList.size()) {
			int coin = coinList.get(i);
			int newSum = sum - coin;
			holder.add(coin);
			//System.out.println("Holder "+holder+" coin ["+coin+"] = ["+newSum+"]");
			if(newSum >= 0) {
				List<Integer> newHolder = new ArrayList<>(holder);
				if(cache.get(newSum) == null) {
					recurseAndMemoize(holder, coinList, newSum, result, cache);
					if(newSum == 0) {
						Collections.sort(newHolder);
						cache.put(sum, newHolder);
					}
				} else {
					newHolder.add(newSum);
					Collections.sort(newHolder);
					result.add(newHolder);
					result.add(cache.get(newSum));
				}
			} 
			holder.remove(holder.size()-1);
			i++;
		}
		
		return result;
		
	}	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 10};
		int target = 10;
		
		Set<List<Integer>> result = new HashSet<>();
		counter = 0;
		result = change(arr, target);
		System.out.println(result);
		System.out.println("Total number of ways ["+result.size()+"]");
		System.out.println("Without memoization, recursed for ["+counter+"]");

		System.out.println("--------------------------------------------------");
		Set<List<Integer>> memoizationResult = new HashSet<>();		
		counter = 0;
		memoizationResult = changeAndMemoize(arr, target);
		System.out.println(memoizationResult);
		System.out.println("Total number of ways ["+memoizationResult.size()+"]");
		System.out.println("With memoization recursed for ["+counter+"]");

	}

}
