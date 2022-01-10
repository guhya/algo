package net.guhya.algo.recursion;

public class Reverse {

	
	public static void reverse(String str, int idx) {
		if (str == null) return;
		if (idx == str.length()) return;
		
		reverse(str, idx+1);
		System.out.print(str.charAt(idx));
	}
	
	public static void main(String[] args) {
		String str = "reverse";
		
		reverse(str, 0);
	}
	
}
