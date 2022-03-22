package net.guhya.algo.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PathInRectangle {

	static boolean isFound = false;
	
	public static void gMatrix() {
		int[][] g = {
					{1, 1, 1, 1, 1},
					{1, 1, 0, 1, 0},
					{1, 1, 1, 1, 1},
					{1, 1, 0, 0, 0},
					{1, 1, 1, 1, 1}
					};
		int m = 5;
		int n = 5;
		int[][] visited = new int[m][n];
		visited[0][0] = 1;
		
		dfsMatrix(g, new int[]{0, 0}, m, n, visited);
		System.out.println("++++++++++");
		
		int[][] visited2 = new int[m][n];
		visited2[0][0] = 1;
		bfsMatrix(g, new int[]{0, 0}, m, n, visited2);
	}
	
	
	private static boolean isVisitable(int[][] g, int[] current, int[] next, int[][] visited) {
		boolean r = false;
		
		r = next[0] >= 0 && next[0] <= (g.length - 1);
		if (r) r = next[1] >= 0 && next[1] <= (g[0].length - 1);
		if (r) r = visited[next[0]][next[1]] == 0;
		if (r) r = g[next[0]][next[1]] == 1;
		
		return r;
	}
	
	private static void markVisited(int[] xy, int[][] visited) {
		visited[xy[0]][xy[1]] = 1;
	}

	public static void dfsMatrix(int[][] g, int[] xy, int m, int n, int[][] visited) {
		if (isFound) return;
		
		int x = xy[0];
		int y = xy[1];
		System.out.print("["+x+","+y+"] -> ");
		
		if (x == m-1 && y == n-1) {
			isFound = true;
			System.out.println("Path found");
			return;
		}
		
		int[] up = {x-1, y};
		if (isVisitable(g, xy, up, visited)) {
			markVisited(up, visited);
			dfsMatrix(g, up, m, n, visited);
		}
	
		int[] right = {x, y+1};
		if (isVisitable(g, xy, right, visited)) {
			markVisited(right, visited);
			dfsMatrix(g, right, m, n, visited);
		}
	
		int[] down = {x+1, y};
		if (isVisitable(g, xy, down, visited)) {
			markVisited(down, visited);
			dfsMatrix(g, down, m, n, visited);
		}
	
		int[] left = {x, y-1};
		if (isVisitable(g, xy, left, visited)) {
			markVisited(left, visited);
			dfsMatrix(g, left, m, n, visited);
		}
	
	}
	
	public static void bfsMatrix(int[][] g, int[] init, int m, int n, int[][] visited) {
		HashMap<int[],int[]> path = new HashMap<>();
		LinkedList<int[]> q = new LinkedList<>();
		q.add(init);
		while (!q.isEmpty()) {
			int[] xy = q.removeFirst();
			int x = xy[0];
			int y = xy[1];
			System.out.print("["+x+","+y+"] -> ");
			markVisited(xy, visited);
			
			if (x == m-1 && y == n-1) {
				System.out.println("Path found");
				break;
			}
			
			int[] up = {x-1, y};
			if (isVisitable(g, xy, up, visited)) {
				path.put(up,  xy);
				q.add(up);
			}
		
			int[] right = {x, y+1};
			if (isVisitable(g, xy, right, visited)) {
				path.put(right,  xy);
				q.add(right);
			}
		
			int[] down = {x+1, y};
			if (isVisitable(g, xy, down, visited)) {
				path.put(down,  xy);
				q.add(down);
			}
		
			int[] left = {x, y-1};
			if (isVisitable(g, xy, left, visited)) {
				path.put(left,  xy);
				q.add(left);
			}
			
		}
		
		int[] target = null;
		for(Map.Entry<int[], int[]> entry : path.entrySet()) {
			int[] k = entry.getKey();
			if (k[0] == m-1 && k[1] == n-1) {
				target = k;
				break;
			}
		}
		
		System.out.println(Arrays.toString(target));
		while(path.get(target) != null) {
			System.out.print(Arrays.toString(target) + " -> ");
			target = path.get(target);
		}
	
	}

	public static void main(String[] args) {
		gMatrix();
	}

}
