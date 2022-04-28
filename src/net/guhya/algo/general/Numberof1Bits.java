package net.guhya.algo.general;

public class Numberof1Bits {

    public static int countBits(int n) {
    	int r = 0;
    	while (n != 0) {
    		r += (n & 1); 
    		n = n >> 1;
    	}
    	
        return r;
    }
	
	public static void main(String[] args) {
		System.out.println(countBits(27));
	}

}
