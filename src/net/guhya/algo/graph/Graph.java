package net.guhya.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private List<LinkedList<Integer>> root = new ArrayList<LinkedList<Integer>>();
	
	public Graph(int n) {
		for (int i=0; i<n; i++) {
			LinkedList<Integer> children = new LinkedList<>();
			root.add(children);
		}
	}
	
	public void add(int src, int dest) {
		root.get(src).add(dest);
	}
	
	public void addUndirected(int src, int dest) {
		root.get(src).add(dest);
		root.get(dest).add(src);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<root.size(); i++) {
			if(root.get(i).size() > 0) {
				sb.append("["+i+"] ");
				LinkedList<Integer> children = root.get(i);
				sb.append(children);
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	
	public List<List<Integer>> findPath(int src, int dst) {
		List<List<Integer>> path = new ArrayList<>();
		findPath(src, dst, new HashSet<Integer>(), new ArrayList<Integer>(), path);
		return path;
	}
	
	public void findPath(int src, int dst, HashSet<Integer> visited, List<Integer> path, List<List<Integer>> result) {
		if (src == dst) {
			path.add(dst);
			List<Integer> tmp = new ArrayList<>(path);
			result.add(tmp);
			return;
		}
		
		visited.add(src);
		path.add(src);
		for (Integer child : root.get(src)) {
			if (!visited.contains(child)) {
				findPath(child, dst, new HashSet<Integer>(visited), new ArrayList<>(path), result);
			}
		}

	}
	
	public void dfsTraversal() {
		dfsTraversal(4, new HashSet<Integer>());
	}

	public void dfsTraversal(Integer node, HashSet<Integer> visited) {
		System.out.print(node + " -> ");
		visited.add(node);
		for(Integer child : root.get(node)) {
			if (!visited.contains(child)) {
				dfsTraversal(child, visited);
			}
		}
	}
	
	public static void printKCores(int k, Graph g) {
        List<Integer> less = new ArrayList<>();
        for(int i=0; i<g.root.size(); i++) {
        	LinkedList<Integer> children = g.root.get(i);
        	if (children.size() > 0 && children.size() < k) {
        		less.add(i);
        	}
        }
        
        if (less.isEmpty()) return;
        
        for(int i=0; i<g.root.size(); i++) {
        	if (!less.contains(i)) {
	            for(Integer r : less) {
	            	g.root.get(i).remove(r);
	            }
        	} else {
        		g.root.get(i).clear();
        	}
        }
        
        printKCores(k, g);
    }	
	
	public static void printKCores(int k) {
        Graph g1 = new Graph(9);
        g1.addUndirected(0, 1);
        g1.addUndirected(0, 2);
        g1.addUndirected(1, 2);
        g1.addUndirected(1, 5);
        g1.addUndirected(2, 3);
        g1.addUndirected(2, 4);
        g1.addUndirected(2, 5);
        g1.addUndirected(2, 6);
        g1.addUndirected(3, 4);
        g1.addUndirected(3, 6);
        g1.addUndirected(3, 7);
        g1.addUndirected(4, 6);
        g1.addUndirected(4, 7);
        g1.addUndirected(5, 6);
        g1.addUndirected(5, 8);
        g1.addUndirected(6, 7);
        g1.addUndirected(6, 8);
        System.out.println(g1);
        printKCores(k, g1);
        System.out.println("Result ");
        System.out.println(g1);
	}
	
	public static int countNodes(int level) {
		int result = 0;
        Graph g = new Graph(7);
        g.addUndirected(0, 1);
        g.addUndirected(0, 2);
        g.addUndirected(1, 3);
        g.addUndirected(1, 4);
        g.addUndirected(1, 5);
        g.addUndirected(2, 6);
		System.out.println(g);
		
		HashSet<Integer> visited = new HashSet<Integer>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int l = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (l == level) {
				System.out.println(q);
				return size;
			}
			for (int i=0; i<size; i++) {
				int n = q.removeFirst();
				visited.add(n);
				for(Integer c : g.root.get(n)) {
					if (!visited.contains(c))
						q.add(c);
				}
			}
			l++;
		}
		
		return result;
	}
	
	public static void gMatrix() {
		int[][] g = {
					{1, 2, 3},
					{2, 3, 1},
					{1, 1, 1}
					};
		int m = 3;
		int n = 3;
		int[][] visited = new int[m][n];
		
		dfsMatrix(g, new int[]{1, 1}, m, n, visited);
		System.out.println("");
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (visited[i][j] == 0)
					System.out.println("["+i+","+j+"]");
			}
		}
		
	}
	
	
	private static boolean isVisitable(int[][] g, int[] current, int[] xy, int[][] visited) {
		boolean r = false;
		r = visited[xy[0]][xy[1]] == 0;
		if (r) r = g[xy[0]][xy[1]] <= g[current[0]][current[1]];
		
		return r;
	}
	
	private static void markVisited(int[] xy, int[][] visited) {
		visited[xy[0]][xy[1]] = 1;
	}

	public static void dfsMatrix(int[][] g, int[] xy, int m, int n, int[][] visited) {
		int x = xy[0];
		int y = xy[1];
		System.out.print("["+x+","+y+"] -> ");
		
		if (x > 0) {
			int[] up = {x-1, y};
			if (isVisitable(g, xy, up, visited)) {
				markVisited(up, visited);
				dfsMatrix(g, up, m, n, visited);
			}
		}
		
		if (y < n-1) {
			int[] right = {x, y+1};
			if (isVisitable(g, xy, right, visited)) {
				markVisited(right, visited);
				dfsMatrix(g, right, m, n, visited);
			}
		}
		
		if (x < m-1) {
			int[] down = {x+1, y};
			if (isVisitable(g, xy, down, visited)) {
				markVisited(down, visited);
				dfsMatrix(g, down, m, n, visited);
			}
		}
		
		if (y > 0) {
			int[] left = {x, y-1};
			if (isVisitable(g, xy, left, visited)) {
				markVisited(left, visited);
				dfsMatrix(g, left, m, n, visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		/*
		System.out.println(path);
		g.dfsTraversal();
		System.out.println("+++++++++++++");
		printKCores(3);
		System.out.println(countNodes(2));
		
		Graph g = new Graph(5);
		g.add(0, 1);
		g.add(0, 2);
		g.add(0, 4);
		g.add(1, 3);
		g.add(1, 4);
		g.add(2, 4);
		g.add(3, 2);
		System.out.println(g);
		List<List<Integer>> path = g.findPath(0, 4);
		System.out.println(path);
		
		*/
		
		gMatrix();
	}

}
