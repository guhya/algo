package net.guhya.algo.general;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OptimalMergePattern {

	static int merge(int[] arr) {
		int result = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {			
				return (o1 > o2) ? 1 : -1;
			}
		});
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		
		while(pq.size() > 1) {
			System.out.print("Item inside " + pq);
			int a = pq.poll();
			int b = pq.poll();
			int r = a + b;
			result += r;			
			System.out.print(" ["+a+"+"+b+"] ["+r+"] Cost ["+result+"] \n");
			pq.add(r);
		}
		
		return result;		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 5, 6};
		int r = merge(arr);
		System.out.println("Minimum Cost ["+r+"]");
	}

}
