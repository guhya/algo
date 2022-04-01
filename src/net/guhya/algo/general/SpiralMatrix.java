package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
    	int h = matrix.length, w = matrix[0].length;
    	int row = 0, col = 0, m = h-1, n = w-1;
    	
    	List<Integer> spiralList = new ArrayList<Integer>();
    	while (spiralList.size() < (h * w)) {
    		for (int i=col; i<=n && spiralList.size() < (h * w); i++) {
    			spiralList.add(matrix[row][i]);
    		}
    		for (int i=row+1; i<m && spiralList.size() < (h * w); i++) {
    			spiralList.add(matrix[i][n]);
    		}
    		for (int i=n; i>=col && spiralList.size() < (h * w); i--) {
    			spiralList.add(matrix[m][i]);
    		}
    		for (int i=m-1; i>row && spiralList.size() < (h * w); i--) {
    			spiralList.add(matrix[i][col]);
    		}
    		row++;
    		n--;
    		col++;
    		m--;
    	}
    	
        return spiralList;
    }
    
	public static void main(String[] args) {
		int[][] matrix1 =  {
							{1	,2	,3, 4},
							{5	,6	,7, 8},
							{9	,10	,11, 12}
						};
		
		System.out.println(spiralOrder(matrix1));

		System.out.println("+++++++++++++");
		
		int [][] matrix2 = {
							{1	,2	,3	,4 	,-4},
							{5	,6	,7	,8  ,-8},
							{9	,10	,11	,12	,-12},
							{13	,14	,15	,16	,-16},
							{17	,18	,19	,20	,-20},
							};
		System.out.println(spiralOrder(matrix2));
		
		System.out.println("+++++++++++++");

		int[][] matrix3 =  {
				{1}
			};

		System.out.println(spiralOrder(matrix3));
	}

}
