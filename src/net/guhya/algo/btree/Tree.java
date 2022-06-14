package net.guhya.algo.btree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	public static void generateLevel(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		root.level = 0;
		root.parent = null;
		q.add(root);
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i=0; i<qSize; i++) {
				TreeNode node = q.poll();
				
				if (node.left != null) {
					node.left.parent = node;
					node.left.level = node.level + 1;
					q.add(node.left);
				}
				
				if (node.right != null) {
					node.right.parent = node;
					node.right.level = node.level + 1;
					q.add(node.right);
				}
			}
		}
	}
	
	public static void printCousin(TreeNode root, String key) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			Stack<TreeNode> s = new Stack<>();
			boolean isFound = false;
			int qSize = q.size();
			for (int i=0; i<qSize; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					if (key.equals(String.valueOf(node.left.val))) {
						isFound = true;
						node.right = null;
					} else {
						s.push(node.left);
					}
					q.add(node.left);
				}
				
				if (node.right != null) {
					if (key.equals(String.valueOf(node.right.val))) {
						s.pop();
						isFound = true;
					} else {
						s.push(node.right);
					}
					q.add(node.right);
				}
			}
			
			if (isFound) {
				System.out.println(s);
				break;
			}
		}
		
	}

	public static int treeHeight(TreeNode root, int max) {
		if (root == null) return max;
		
		return Math.max(treeHeight(root.left, max + 1), treeHeight(root.right, max + 1));
	}
	
	public static int countNode(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			TreeNode n = q.poll();
			if (n.left != null) q.add(n.left);
			if (n.right != null) q.add(n.right);
		}
		
		return count;
	}
	
	public static void toArray(TreeNode root) {
		int nodeCount = countNode(root);
		int maxElementCount = (int) Math.pow(2, nodeCount) - 1;
		int treeHeight = treeHeight(root, 0);
		int actualElementCount = (int) Math.pow(2, treeHeight) - 1;
		
		TreeNode[] nodes = new TreeNode[actualElementCount];
		Map<Integer, Integer> indexMap = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		indexMap.put(root.val, 0);
		nodes[0] = root;
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			int idx = indexMap.get(n.val);
			if (n.left != null) {
				q.add(n.left);
				nodes[2*idx+1] = n.left;
				indexMap.put(n.left.val, 2*idx+1);
			}
			
			if (n.right != null) {
				q.add(n.right);
				nodes[2*idx+2] = n.right;
				indexMap.put(n.right.val, 2*idx+2);
			}
		}
		
		System.out.println("Total nodes : " + nodeCount);
		System.out.println("Max possible nodes : " + maxElementCount);
		System.out.println("Actual nodes : " + actualElementCount);
		
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
	
	public static void printLeavePath(TreeNode root, String path) {
		if (root == null) {
			System.out.println(path);
			return;
		}
		
		printLeavePath(root.left, path + " " + root.val);
		printLeavePath(root.right, path + " " + root.val);
	}
	
	public static void printPath(TreeNode root, String path, String key) {
		if (root == null) return;
		
		if (key.equals(String.valueOf(root.val))) {
			System.out.println(path + root.val);
			return;
		}
		
		printPath(root.left, path + root.val + "->", key);
		printPath(root.right, path + root.val + "->", key);
	}
	
	public static boolean isTherePath(TreeNode root, String key, Stack<TreeNode> s) {
		if (root == null) {
			return false;
		}
		
		s.add(root);
		if (key.equals(String.valueOf(root.val))) {
			return true;
		}
		
		if (isTherePath(root.left, key, s) || isTherePath(root.right, key, s)) {
			return true;
		}
		
		s.pop();
		return false;
	}
	
	public static void inorder(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.val + ", ");
		inorder(root.left);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(7);
		tree.left.left.left = new TreeNode(8);
		tree.left.left.right = new TreeNode(28);
		tree.left.right.left = new TreeNode(9);
		tree.left.right.right = new TreeNode(10);
		tree.right.left.left = new TreeNode(11);
		tree.right.right.left = new TreeNode(12);
		
		generateLevel(tree);
		
		toArray(tree);
		System.out.println("++++++++++");
		printCousin(tree, "9");
		System.out.println("++++++++++");
		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);
		tree2.left.left = new TreeNode(4);
		tree2.left.right = new TreeNode(5);
		printLeavePath(tree2, "");
		System.out.println("++++++++++");
		printPath(tree2, "", "5");
		System.out.println("++++++++++");
		printPath(tree2, "", "6");
		System.out.println("++++++++++");
		Stack<TreeNode> path = new Stack<>();
		System.out.println(isTherePath(tree2, "5", path)); 
		System.out.println(path);
		
		System.out.println("++++++++++++");
		inorder(tree);
	}
	
}
