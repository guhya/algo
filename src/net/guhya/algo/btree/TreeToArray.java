package net.guhya.algo.btree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeToArray {

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
	
	public static int treeHeight(Node root, int max) {
		if (root == null) return max;
		
		return Math.max(treeHeight(root.left, max + 1), treeHeight(root.right, max + 1));
	}
	
	public static int countNode(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			Node n = q.poll();
			if (n.left != null) q.add(n.left);
			if (n.right != null) q.add(n.right);
		}
		
		return count;
	}
	
	public static void toArray(Node root) {
		int nodeCount = countNode(root);
		int maxElementCount = (int) Math.pow(2, nodeCount) - 1;
		int treeHeight = treeHeight(root, 0);
		int actualElementCount = (int) Math.pow(2, treeHeight) - 1;
		
		Node[] nodes = new Node[actualElementCount];
		Map<String, Integer> indexMap = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		indexMap.put(root.data, 0);
		nodes[0] = root;
		while (!q.isEmpty()) {
			Node n = q.poll();
			int idx = indexMap.get(n.data);
			if (n.left != null) {
				q.add(n.left);
				nodes[2*idx+1] = n.left;
				indexMap.put(n.left.data, 2*idx+1);
			}
			
			if (n.right != null) {
				q.add(n.right);
				nodes[2*idx+2] = n.right;
				indexMap.put(n.right.data, 2*idx+2);
			}
		}
		
		System.out.println("Total nodes : " + nodeCount);
		System.out.println("Max possible nodes : " + maxElementCount);
		System.out.println("Actual nodes : " + actualElementCount);
		System.out.println(Arrays.toString(nodes));
		
		int index = 0;
		for (int i=0; i<treeHeight; i++) {
			int elementCount = (int) Math.pow(2, i);
			int c = 0;
			while (c < elementCount) {
				System.out.print(nodes[index] + " ");
				c++;
				index++;
			}
			System.out.println("");
		}
	}
	
	
	
	public static void main(String[] args) {
		Node tree = new Node("10");
		tree.left = new Node("7");
		tree.right = new Node("15");
		tree.left.left = new Node("1");
		tree.left.right = new Node("9");
		tree.left.right.left = new Node("11");
		tree.left.right.right = new Node("13");
		tree.left.right.right.left = new Node("14");
		tree.left.right.right.right = new Node("12");
		
		toArray(tree);
	}

}
