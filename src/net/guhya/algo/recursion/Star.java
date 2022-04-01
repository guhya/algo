package net.guhya.algo.recursion;

public class Star {

	private static void printStars(int i, int j) {
		if (j == (i)) {
			print(i, i);
			return;
		}
		
		print(j, i);
		printStars(i, j+2);
		print(j, i);
	}
	
	private static void print(int times, int total) {
		for(int i=0; i<(total-times)/2; i++) {
			System.out.print(" ");
		}
		for(int i=1; i<=times; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		printStars(11, 1);
	}
}
