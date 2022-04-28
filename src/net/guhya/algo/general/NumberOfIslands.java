package net.guhya.algo.general;

public class NumberOfIslands {

    public static void numIslandsUtil(char[][] grid, int row, int col, int[][] visited) {
    	if (row < 0 || row >= grid.length) return;
    	if (col < 0 || col >= grid[0].length) return;
    	if (grid[row][col] == '0') return;
    	if (visited[row][col] == 1) return;
    	
    	visited[row][col] = 1;
    	numIslandsUtil(grid, row+1, col, visited);
    	numIslandsUtil(grid, row, col+1, visited);
    	numIslandsUtil(grid, row, col-1, visited);
    	numIslandsUtil(grid, row-1, col, visited);
    }

    public static int numIslands(char[][] grid) {
    	int[][] visited = new int[grid.length][grid[0].length];
    	int num = 0;
    	for (int i=0; i<visited.length; i++) {
        	for (int j=0; j<visited[0].length; j++) {
        		if (visited[i][j] == 0 && grid[i][j] == '1') {
        			num++;
        	    	numIslandsUtil(grid, i, j, visited);
        		}
        	}
    	}
    	
    	return num;
    }
	
	public static void main(String[] args) {
		char[][] grid1 = {
		                  {'0','0','0','0','0'},
		                  {'0','0','0','0','0'},
		                  {'0','0','0','0','0'},
		                  {'0','0','0','1','1'}
		                };
		System.out.println(numIslands(grid1));
		System.out.println("++++++++++");
		char[][] grid2 = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'},
              };
		System.out.println(numIslands(grid2));
	}

}
