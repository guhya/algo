package net.guhya.algo.general;

import java.util.LinkedList;

public class ValidParentheses {

    /**
     * Use stack 
     * Push all open parenthesis
     * Every time we encounter closed parenthesis, we pull from the top stack
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
    	LinkedList<Character> stack = new LinkedList<>();
    	for (int i=0; i<s.length(); i++) {
    		Character c = s.charAt(i);
    		if (c == '(' || c == '{' || c == '[') {
    			stack.add(c);
    		} else {
    			if (stack.isEmpty()) return false;
    			if ((c == ')' && stack.peekLast() == '(') || (c == '}' && stack.peekLast() == '{') || (c == ']' && stack.peekLast() == '[')) {
    				stack.removeLast();
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
