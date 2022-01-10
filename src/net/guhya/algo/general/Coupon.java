package net.guhya.algo.general;

public class Coupon {

	public static boolean isValid(String str) {
		if (str == null) return false;
		if ("".equals(str)) return true;
		
		int len = str.length();
		if (len == 2) {
			if (str.charAt(0) == str.charAt(1)) 
				return true;
			else
				return false;
		} else {
			int l = 0;
			int h = len-1;
			boolean isPalindrome = true;
			while (l < h) {
				if (str.charAt(l) == str.charAt(h)) {
					l++;
					h--;
				} else {
					isPalindrome = false;
					break;
				}
			}
			
			if (isPalindrome) {
				return true;
			} else {
				int mid = ((h-l) / 2) - 1;
				str = str.substring(l, h);
				String left = str.substring(0, mid+1);
				String right = str.substring(mid+1, str.length()-1);
				return isValid(left) && isValid(right);
			}
		}
	}

	
	public static void main(String[] args) {
		String coupon = "ffaaveev";
		
		System.out.println(isValid(coupon));
	}

}
