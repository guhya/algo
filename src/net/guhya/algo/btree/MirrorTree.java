package net.guhya.algo.btree;

import java.util.ArrayList;
import java.util.List;

public class MirrorTree {

	public static class Node {
		public String data;
		public Node left;
		public Node right;
		
		public Node(String data) {
			this.data = data;
		}
		
		public String toString() {
			return this.data;
		}
	}

	public static void pathLeft(Node root, List<Integer> path) {
		if (root == null) return;
		
		if (root.left != null) {
			path.add(-1);
			pathLeft(root.left, path);
		} 
		
		if (root.right != null) {
			path.add(1);
			pathLeft(root.right, path);
		} 
	}
	
	public static void pathRight(Node root, List<Integer> path) {
		if (root == null) return;
		
		if (root.right != null) {
			path.add(1);
			pathRight(root.right, path);
		} 

		if (root.left != null) {
			path.add(-1);
			pathRight(root.left, path);
		} 
	}

	public static int rec(int l, int h) {
		if (l == h) return h;
		
		return l + rec(l+1, h);
	}
	
	public static int recV(int l, int h) {
		if (l == h) return h;
		
		l = l + recV(l+1, h);
		return l;
	}

	public static int recS(int l, int h, int sum) {
		if (l > h) return sum;
		
		return recS(l+1, h, sum+l);
	}

	public static void main(String[] args) {
		Node root = new Node("1");
		root.left = new Node("2");
		root.right = new Node("3");
		//root.left.left= new Node("4");
		root.left.right= new Node("5");
		root.right.left= new Node("6");
		//root.right.right= new Node("7");
		
		List<Integer> trackerLeft = new ArrayList<Integer>();
		trackerLeft.add(-1);
		pathLeft(root.left, trackerLeft);
		List<Integer> trackerRight = new ArrayList<Integer>();
		trackerRight.add(1);
		pathRight(root.right, trackerRight);
		
		System.out.println(trackerLeft);
		System.out.println(trackerRight);
		System.out.println("+++++++++++");
		System.out.println(rec(1, 5));
		System.out.println("+++++++++++");
		System.out.println(recV(1, 5));
		System.out.println("+++++++++++");
		System.out.println(recS(1, 5, 0));
	}

}
