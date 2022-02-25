package net.guhya.algo.array;

public class RotateMatrix90 {

	public static void rotateMatrix(int[][] matrix, int m, int n) {
		int height = m;
		int length = n;
		int row = 0;
		int col = 0;
		
		while (col != n && Math.abs(col-n) != 1) {
			int i = col;
			while (i < (m-1)){
				int tmp = matrix[row][col+i];
				matrix[row][col+i] = matrix[row+i][n-1];
				matrix[row+i][n-1] = matrix[m-1][n-1-i];
				matrix[m-1][n-1-i] = matrix[m-1-i][col];
				matrix[m-1-i][col] = tmp;
				i++;
			}
			row++;
			col++;
			m--;
			n--;
		}
		
		for (int i=0; i<height; i++) {
			for (int j=0; j<length; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		int[][] matrix1 = {
						  {1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}
						};
		
		rotateMatrix(matrix1, 3, 3);
		System.out.println("++++++++++++");
		
		int[][] matrix2 = {
				  {1,  2,  3,  4},
				  {5,  6,  7,  8},
				  {9,  10, 11, 12},
				  {13, 14, 15, 16}
				};

		rotateMatrix(matrix2, 4, 4);
		
	}

}
