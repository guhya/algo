package net.guhya.algo.btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class BinaryTree {

	public Node root;
	
	public static class Node {
		public Node left;
		public Node right;
		public int data;
		public int dfr;
		
		public Node(int value) {
			this.data = value;
		}
		
		public String toString() {
			return String.valueOf(data + "(" + dfr + ")");
		}
	}
	
	public Map<Integer, ArrayList<Node>> distanceFromRoot() {
		Map<Integer, ArrayList<Node>> distance = new HashMap<>();
		if (root == null) return distance;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		root.dfr = 0;
		ArrayList<Node> listNode = new ArrayList<>();
		listNode.add(root);
		distance.put(0, listNode);
		
		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current.left != null) {
				current.left.dfr = current.dfr - 1;
				q.add(current.left);
				
				ArrayList<Node> ln = distance.get(current.left.dfr) == null ? 
						new ArrayList<>() : distance.get(current.left.dfr);
				ln.add(current.left);
				distance.put(current.left.dfr, ln);
			}
			
			if (current.right != null) {
				current.right.dfr = current.dfr + 1;
				q.add(current.right);
				
				ArrayList<Node> ln = distance.get(current.right.dfr) == null ? 
						new ArrayList<>() : distance.get(current.right.dfr);
				ln.add(current.right);
				distance.put(current.right.dfr, ln);
				
			}
			
		}
		
		return distance;
	}
	
	public void distanceFromRootRecursive(Node current, int distance, Map<Integer, ArrayList<Node>> distanceMap) {
		if (current == null) return;
		
		ArrayList<Node> ln = distanceMap.get(distance) == null ? 
				new ArrayList<>() : distanceMap.get(distance);
		ln.add(current);
		distanceMap.put(distance, ln);
		
		distanceFromRootRecursive(current.left, distance - 1, distanceMap);
		distanceFromRootRecursive(current.right, distance + 1, distanceMap);
	}

	
	public void traverse() {
		if (root == null) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current != root && q.isEmpty()) 
				sb.append(current);
			else
				sb.append(current + ", ");
				
			if (current.left != null) q.add(current.left);
			if (current.right != null) q.add(current.right);
			
		}
		sb.append("]");
		
		System.out.println(sb.toString());
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right = new Node(3);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.right = new Node(8);
		bt.root.right.right.right = new Node(9);
		
		bt.traverse();
		Map<Integer, ArrayList<Node>> distance = bt.distanceFromRoot();
		int min = 0, max = 0;
		for (Entry<Integer, ArrayList<Node>> k : distance.entrySet()) {
			if (k.getKey() < min) min = k.getKey();
			if (k.getKey() > max) max = k.getKey();
		}
		
		for(int i=min; i<=max; i++) {
			System.out.println(distance.get(i));
		}
		
		bt.traverse();
		System.out.println("----------------------------------");
		Map<Integer, ArrayList<Node>> distanceMap = new HashMap<>();
		bt.distanceFromRootRecursive(bt.root, 0, distanceMap);
		min = 0;
		max = 0;
		for (Entry<Integer, ArrayList<Node>> k : distanceMap.entrySet()) {
			if (k.getKey() < min) min = k.getKey();
			if (k.getKey() > max) max = k.getKey();
		}
		for(int i=min; i<=max; i++) {
			System.out.println(distanceMap.get(i));
		}
		
	}

}
