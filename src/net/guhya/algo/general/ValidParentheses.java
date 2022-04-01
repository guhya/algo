package net.guhya.algo.general;

import java.util.LinkedList;

public class ValidParentheses {

    public static boolean isValid(String s) {
    	LinkedList<Character> stack = new LinkedList<>();
    	for (int i=0; i<s.length(); i++) {
    		Character c = s.charAt(i);
    		if (c == '(' || c == '{' || c == '[') {
    			stack.push(c);
    		} else {
    			if (stack.isEmpty()) return false;
    			if ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
    				stack.pop();
    			} else {
    				return false;
    			}
    		}
    	}
    	
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String s = "()";
		System.out.println(isValid(s));
	}

}
