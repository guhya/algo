package net.guhya.algo.recursion;

public class Reverse {

	public static void reverse(String str, int idx) {
		if (str == null) return;
		if (idx == str.length()) return;
		
		reverse(str, idx+1);
		System.out.print(str.charAt(idx));
	}
	
	public static String reverse(String str) {
		if (str.length() == 1) return str;
		
		return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
	}
	
	public static void main(String[] args) {
		String str = "reverse";
		
		reverse(str, 0);
		String rev = reverse("try to reverse this long ass string");
		System.out.println("\n+++++++++");
		System.out.println(rev);
	}
	
}
