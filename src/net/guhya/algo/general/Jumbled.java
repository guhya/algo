package net.guhya.algo.general;

public class Jumbled {

    /**
     * To generate string variation, brute force it
     * @param s
     * @param shuffle
     */
	public static void jumble(String s, String shuffle) {
		if (s.length() == 0) {
			System.out.println(shuffle);
			return;
		}
		
		for (int i=0; i<s.length(); i++) {
			String nshuffle = shuffle + s.charAt(i);
			String ns = "";
			for (int j=0; j<s.length(); j++) {
				if (j!=i) {
					ns += s.charAt(j);
				}
			}
			jumble(ns, nshuffle);
		}
		
	}
	
	public static void main(String[] args) {
		String s = "ABCDE";
		jumble(s, "");
	}

}
