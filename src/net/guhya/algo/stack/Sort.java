package net.guhya.algo.stack;

import java.util.LinkedList;

public class Sort {
	
	
	public static void sort(LinkedList<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		
		int v = stack.pop();
		sort(stack);
		
		put(stack, v);
	}
	
	public static void put(LinkedList<Integer> stack, Integer x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		
		if (x < stack.peek()) {
			stack.push(x);
			return;
		}
		
		int v = stack.pop();
		put(stack, x);
		stack.push(v);
	}
	

	public static void main(String[] args) {
		
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);
		
		System.out.println(stack);
		sort(stack);
		System.out.println(stack);

	}

}
