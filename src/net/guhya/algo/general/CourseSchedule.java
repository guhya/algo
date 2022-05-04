package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

	public static class Node {
		public int val;
		public List<Node> neighbors;
		public Node(int val) {
			this.val = val;
			this.neighbors = new ArrayList<>();
		}
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	public static boolean isCyclic(Node root, Set<Node> visited, LinkedList<Node> path) {
		if (path.contains(root)) {
			System.out.println(root + " Cyclic");
			return true;
		}
		
		if (visited.contains(root)) return false;
		
		System.out.print(root.val + " -> ");
		visited.add(root);
		path.add(root);
		for (Node n : root.neighbors) {
			if (isCyclic(n, visited, path)) return true;
		}
		path.remove(root);
		
		return false;
	}
	
	public static void findPath(Node root, Node dest, Set<Node> visited, LinkedList<Node> path) {
		if (visited.contains(root)) {
			return;
		}
		
		if (root == dest) {
			path.add(root);
			System.out.println(path);
		}
		
		path.add(root);
		visited.add(root);
		for (Node n : root.neighbors) {
			findPath(n, dest, visited, path);
		}
		path.removeLast();
	}
	
	public static void findAllPath(Node root, Node dest, Set<Node> visited, LinkedList<Node> path) {
		if (visited.contains(root)) {
			return;
		}
		
		if (root == dest) {
			path.add(root);
			System.out.println(path);
		}
		
		for (Node n : root.neighbors) {
			Set<Node> newVisited = new HashSet<>(visited);
			newVisited.add(root);
			LinkedList<Node> newPath = new LinkedList<>(path);
			newPath.add(root);
			findPath(n, dest, newVisited, newPath);
		}
	}

	
	public static boolean isCyclicUtil(ArrayList<Integer>[] g, int idx, int[] visited, int[] path, LinkedList<Integer> stack) {
		if (path[idx] == 1) return true;
		if (visited[idx] == 1) return false;
		
		visited[idx] = 1;
		path[idx] = 1;
		for (Integer i : g[idx]) {
			if (isCyclicUtil(g, i, visited, path, stack)) {
				return true;
			}
		}
		path[idx] = 0;
		stack.add(idx);
		
		return false;
	}

	public static boolean isAcyclic(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] g = new ArrayList[numCourses];
		for (int i=0; i<g.length; i++) {
			g[i] = new ArrayList<>();
		}
		for (int[] p : prerequisites) {
			g[p[0]].add(p[1]);
		}
		
		System.out.println(Arrays.toString(g));
		
		int[] visited = new int[g.length];
		int[] path = new int[g.length];
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i=0; i<g.length; i++) {
			if (isCyclicUtil(g, i, visited, path, stack)) {
				return false;
			}
		}
		
		System.out.println("Topological order : " + stack);
		
		return true;
	}
	
	public static void main(String[] args) {
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n0.neighbors.add(n1);
		n0.neighbors.add(n2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n0);
		n2.neighbors.add(n3);
		List<Node> g1 = new ArrayList<>();
		g1.add(n1);
		g1.add(n2);
		g1.add(n0);
		g1.add(n3);
		
		Set<Node> visited = new HashSet<Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		findPath(n0, n3, visited, path);
		findAllPath(n0, n3, new HashSet<Node>(), new LinkedList<Node>());
		visited.clear();
		path.clear();
		for(Node n : g1) {
			System.out.println(isCyclic(n, visited, path));
		}
		
		System.out.println("+++++++++++");
		int[][] preq1 = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
		System.out.println(isAcyclic(20, preq1));
		System.out.println("+++++++++++");
		int[][] preq2 = {{1,1}};
		System.out.println(isAcyclic(2, preq2));
		System.out.println("+++++++++++");
		int[][] preq3 = {{1,0},{1,2},{0,1}};
		System.out.println(isAcyclic(3, preq3));
		System.out.println("+++++++++++");
		int[][] preq4 = {{2,3},{3,1},{4,0},{4,1},{5,2},{5,0}};
		System.out.println(isAcyclic(6, preq4));
		System.out.println("+++++++++++");
		int[][] preq5 = {{0,2},{0,3},{1,3},{1,4},{2,3},{2,5},{3,5},{4,5}};
		System.out.println(isAcyclic(6, preq5));
	}

}
