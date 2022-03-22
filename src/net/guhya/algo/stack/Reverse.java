package net.guhya.algo.stack;

import java.util.LinkedList;

public class Reverse {
	
	
	public static void reverse(LinkedList<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		
		int v = stack.pop();
		reverse(stack);
		pushUnder(stack, v);
	}
	
	public static void pushUnder(LinkedList<Integer> stack, Integer x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		
		int v = stack.pop();
		pushUnder(stack, x);
		stack.push(v);
	}
	

	public static void main(String[] args) {
		
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);

	}

}
