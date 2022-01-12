package net.guhya.algo.general;

import java.util.Stack;

public class Coupon {

	public static boolean isValid(String str) {
		if (str == null) return false;
		int len = str.length();
		if(len == 0) return true;
		
		Stack<Character> s = new Stack<>();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (s.isEmpty()) {
				s.add(c);
			} else {
				if (c == s.peek()) {
					s.pop();
				} else {
					s.add(c);
				}
			}
		}
		
		System.out.println(s);
		return s.isEmpty();
	}

	
	public static void main(String[] args) {
		String coupon = "ffaaveev";
		System.out.println(isValid(coupon));
		System.out.println("+++++++++++++");
		coupon = "dffaaveeve";
		System.out.println(isValid(coupon));
	}

}
