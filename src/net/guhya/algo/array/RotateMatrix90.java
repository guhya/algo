package net.guhya.algo.array;

public class RotateMatrix90 {

	public static void rotateMatrix(int[][] matrix, int m, int n) {
		int height = m;
		int length = n;
		int row = 0;
		int col = 0;
		m--;
		n--;
		
		while (col < n) {
			int i = 0;
			while ((col+i) < m){
				int tmp = matrix[row][col+i];
				matrix[row][col+i] = matrix[m-i][col];
				matrix[m-i][col] = matrix[m][n-i];
				matrix[m][n-i] = matrix[row+i][n];
				matrix[row+i][n] = tmp;
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
		
		int[][] matrix = {
				  {1, 2},
				  {3, 4},
				};

		rotateMatrix(matrix, 2, 2);
		System.out.println("++++++++++++");

		int[][] matrix1 = {
						  {1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}
						};
		
		rotateMatrix(matrix1, 3, 3);
		System.out.println("++++++++++++");
		
		
		int[][] matrix2 = {
							{2	,29	,20	,26	,16	,28},
							{12	,27	,9	,25	,13	,21},
							{32	,33	,32	,2	,28	,14},
							{13	,14	,32	,27	,22	,26},
							{33	,1	,20	,7	,21	,7},
							{4	,24	,1	,6	,32	,34}};

		rotateMatrix(matrix2, 6, 6);
		
	}

}
