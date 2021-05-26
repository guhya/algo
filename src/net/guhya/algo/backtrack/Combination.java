package net.guhya.algo.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Combination {

	static int counter = 0;
	
	public static List<Set<Integer>> combine(int[] arr, int k) {
		List<Integer> source = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			source.add(arr[i]);
		}
		
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		return recurse(new TreeSet<Integer>(), source, 0, k, result);
	}
	
	private static List<Set<Integer>> recurse(Set<Integer> holder, List<Integer> source
			, int offset, int k, List<Set<Integer>> result) {
		
		counter++;
		
		if(holder.size() == k) {
			result.add(holder);
			return result;
		}
		
		int i = offset;
		while(i<source.size()) {
			int el = source.get(i);
			i++;
			if(!holder.contains(el)) {
				Set<Integer> newHolder = new TreeSet<>(holder);
				newHolder.add(el);
				offset++;
				recurse(newHolder, source, offset, k, result);
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		List<Set<Integer>> result = new ArrayList<Set<Integer>>();
		result = combine(arr, 3);
		System.out.println(result);
		System.out.println("Total combination count ["+result.size()+"]");
		System.out.println("Recursed for ["+counter+"]");
	}

}
