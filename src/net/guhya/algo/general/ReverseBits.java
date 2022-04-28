package net.guhya.algo.general;

public class ReverseBits {

    public static int reverseBits(int n) {
    	String s = Integer.toString(n, 2);
    	StringBuilder sb = new StringBuilder();
    	for (int i=4	; i>s.length(); i--) {
    		sb.append("0");
    	}
    	s = sb.toString() + s;
    	String rs = new StringBuilder().append(s).reverse().toString();
    	System.out.println(s + " " + rs);
    	
        return Integer.parseInt(rs, 2);
    }
    
    public static int reverseBitsBinary(int n) {
    	int r = 0;
    	for (int i=1; i<=32; i++) {
    		r = r | (n & 1);
    		System.out.println(Integer.toBinaryString(r) + " " + Integer.toBinaryString(n));
    		n = n >> 1;
    		r = r << 1;
    	}
    	
        return r;
    }
    
	
	
	public static void main(String[] args) {
		System.out.println(reverseBits(11));
		
		int v = 32;
		do {v >>= 1;System.out.println(v);} while (v > 0);
		System.out.println("++++++++++");
		System.out.println(5&1);
		System.out.println(4&1);
		System.out.println(5|1);
		System.out.println(5^1);
		System.out.println(~5);
		int n = 5;
		System.out.println(n&1);
		System.out.println("+++++++++++");
		System.out.println(reverseBitsBinary(5));
	}

}
