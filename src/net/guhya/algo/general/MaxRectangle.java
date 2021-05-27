package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxRectangle {
	
	public static void findRectangle(int[][] matrix) {
		
		Map<String, Integer> recListMap = new HashMap<>();
		Map<String, Integer> recListCounter = new HashMap<>();

		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					int k = j+1;
					List<Integer> recList = new ArrayList<>();
					recList.add(j);
					while (k < matrix[i].length && matrix[i][k] == 1) {
						recList.add(k);
						
						boolean newRect = false;
						for (Integer v : recList) {
							if (i == 0) {
								newRect = true;
								break;
							}
							
							if (matrix[i-1][v] != 1) {
								newRect = true;
								break;
							}
							
						}
						
						String key = generateKey(recList);
						String fullKey = "";
						if (newRect) {
							// New rectangle, increment counter
							fullKey = i  + "|" + key;
							recListCounter.put(key, i);
						} else {
							fullKey = recListCounter.get(key)  + "|" + key;
						}
						int val = recListMap.get(fullKey) == null ? 0 : recListMap.get(fullKey);
						recListMap.put(fullKey, val+1);
						k++;
					}
				}
			}
		}
		
		for (Map.Entry<String, Integer> entry : recListMap.entrySet()) {
			String k = entry.getKey();
			int v = entry.getValue();
			int l = 0;
			for (int i=0; i<k.length(); i++) {
				if (k.charAt(i) == '-') l++;
			}
			int area = l * v;
			
			if (v > 1)
				System.out.println(k + " = " + v + " ["+l+" * "+v+" = "+area+"]");
		}
		
	}
	
	private static String generateKey(List<Integer> recList) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : recList) {
			sb.append(i+"-");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[][] matrix = {
					         {1, 1, 0, 1, 1, 0, 1},
					         {0, 1, 0, 1, 1, 0, 1},
					         {1, 1, 1, 1, 1, 1, 1},
					         {1, 1, 1, 1, 1, 1, 1},
					         {1, 1, 1, 1, 1, 1, 1}
						 };
		
		findRectangle(matrix);
	}

}
