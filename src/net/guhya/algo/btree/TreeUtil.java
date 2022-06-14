package net.guhya.algo.btree;

import net.guhya.algo.btree.TreeNode;

public class TreeUtil {

	private static TreeNode buildTreeUtil(Integer[] arr, int idx) {
		if (idx > arr.length-1) return null;
		
		TreeNode node = null;
		if (arr[idx] != null) { 
			node = new TreeNode(arr[idx]);
			node.left = buildTreeUtil(arr, 2*idx+1);
			node.right = buildTreeUtil(arr, 2*idx+2);
		}
		
		return node;
	}
	
	public static TreeNode buildTree(Integer[] arr) {
		TreeNode root = buildTreeUtil(arr, 0);
		return root;
	}
	
	public static void traversePre(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.val + " -> ");
		traversePre(root.left);
		traversePre(root.right);
	}
	
	public static void traverseIn(TreeNode root) {
		if (root == null) return;
		
		traverseIn(root.left);
		System.out.print(root.val + " -> ");
		traverseIn(root.right);
	}

	public static void traversePost(TreeNode root) {
		if (root == null) return;
		
		traversePost(root.left);
		traversePost(root.right);
		System.out.print(root.val + " -> ");
	}	
}
