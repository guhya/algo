package net.guhya.algo.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

	public Node root;
	
	public static class Node {
		public Node left;
		public Node right;
		public int data;
		
		public Node(int value) {
			this.data = value;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	public Node insert(Node current, int value) {
		
		if (current == null) {
			current = new Node(value);
			return current;
		}
		
		if (current.data > value) 
			current.left = insert(current.left, value);
		else
			current.right = insert(current.right, value);
		
		return current;
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
				sb.append(current.data);
			else
				sb.append(current.data + ", ");
				
			if (current.left != null) q.add(current.left);
			if (current.right != null) q.add(current.right);
			
		}
		sb.append("]");
		
		System.out.println(sb.toString());
	}
	
	public void traverseInOrder(Node root, List<Node> nodeList) {
		if (root == null) return;
		
		traverseInOrder(root.left, nodeList);
		nodeList.add(root);
		traverseInOrder(root.right, nodeList);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new Node(8);
		bst.insert(bst.root, 3);
		bst.insert(bst.root, 10);
		bst.insert(bst.root, 1);
		bst.insert(bst.root, 6);
		bst.insert(bst.root, 14);
		bst.insert(bst.root, 4);
		bst.insert(bst.root, 7);
		bst.insert(bst.root, 13);
		
		bst.traverse();
		List<Node> nodeList = new ArrayList<>();
		bst.traverseInOrder(bst.root, nodeList);
		System.out.println(nodeList);
		
	}

}
