package net.guhya.algo.stack;

import java.util.LinkedList;

public class MaximumDepth {

	private static int getMaxDepth(String sentence) {
		int len = sentence.length();
		int depth = 0, maxDepth = 0;
		LinkedList<Character> stack = new LinkedList<>();
		for (int i=0; i<len; i++) {
			char c = sentence.charAt(i);
			if (c == '(') {
				stack.push('(');
				depth++;
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') return -1;
				stack.pop();
				depth--;
			}
			
			maxDepth = Math.max(depth, maxDepth);
		}
		
		return stack.isEmpty() ? maxDepth : -1;
	}
	
	public static void main(String[] args) {
		String sentence = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		System.out.println("Max Depth [" + getMaxDepth(sentence) + "]");
		
		sentence = "( p((q)) ((s)t) )";
		System.out.println("Max Depth [" + getMaxDepth(sentence) + "]");

		sentence = "";
		System.out.println("Max Depth [" + getMaxDepth(sentence) + "]");

		sentence = "b) (c) ()";
		System.out.println("Max Depth [" + getMaxDepth(sentence) + "]");

		sentence = "(b) ((c) ()";
		System.out.println("Max Depth [" + getMaxDepth(sentence) + "]");

	}

}
