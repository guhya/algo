package net.guhya.algo.array;

public class RotateMatrix {

	public static void rotateMatrix(int[][] matrix, int m, int n) {
		int height = m;
		int length = n;
		int row = 0;
		int col = 0;
		
		while (col != n && Math.abs(col-n) != 1) {
			int current = 0;
			int tmp = matrix[row+1][col];
			for (int i=col; i<n; i++) {
				current = matrix[row][i];
				matrix[row][i] = tmp;
				tmp = current;
			}
			row++;
			
			for (int i=row; i<m; i++) {
				current = matrix[i][n-1];
				matrix[i][n-1] = tmp;
				tmp = current;
			}
			n--;
			
			for (int i=n-1; i>=col; i--) {
				current = matrix[m-1][i];
				matrix[m-1][i] = tmp;
				tmp = current;
			}
			m--;
			
			for (int i=m-1; i>=row; i--) {
				current = matrix[i][col];
				matrix[i][col] = tmp;
				tmp = current;
			}
			col++;
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
