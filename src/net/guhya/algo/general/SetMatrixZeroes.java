package net.guhya.algo.general;

public class SetMatrixZeroes {

    public static void setZeroesBasic(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		if (matrix[i][j] == 0) {
        			int k = 0;
        			while (k < m) {
        				if (matrix[k][j] != 0) matrix[k][j] = -1;
        				k++;
        			}
        			k = 0;
        			while (k < n) {
        				if (matrix[i][k] != 0) matrix[i][k] = -1;
        				k++;
        			}
        		}
        	}
    	}
    	
    	for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		if (matrix[i][j] == 0 || matrix[i][j] == -1) matrix[i][j] = 0;
        	}
    	}
    	
    }
	
    public static void setZeroes(int[][] matrix, int row, int col) {
    	boolean firstRow = false;
    	boolean firstColumn = false;
    	
    	for (int i=0; i<matrix.length; i++) {
    		if (matrix[i][0] == 0) firstColumn = true;
        	for (int j=0; j<matrix[0].length; j++) {
        		if (i == 0 && matrix[i][j] == 0) firstRow = true;
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
    	}
    	
    	for (int j=1; j<matrix[0].length; j++) {
    		if (matrix[0][j] == 0) {
    			for (int i=1; i<matrix.length; i++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}

    	for (int i=1; i<matrix.length; i++) {
    		if (matrix[i][0] == 0) {
    			for (int j=1; j<matrix[0].length; j++) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	if (firstRow) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
    	}
    	
    	if (firstColumn) {
			for (int j=0; j<matrix.length; j++) {
				matrix[j][0] = 0;
			}
    	}
    }
    

    public static void main(String[] args) {
		int[][] matrix1 = {
							{0	,2	,0},
							{4	,1	,6},
							{7	,8	,9}
						};
		
		setZeroes(matrix1, 0, 0);
		
    	for (int i=0; i<matrix1.length; i++) {
        	for (int j=0; j<matrix1[0].length; j++) {
        		System.out.format("%d\t", matrix1[i][j]);
        	}
        	System.out.println("");
    	}
    	System.out.println("+++++++++++");
	}

}
