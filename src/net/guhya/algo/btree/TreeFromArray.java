package net.guhya.algo.btree;

public class TreeFromArray {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static TreeNode buildTreeUtil(Integer[] arr, int idx) {
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
	
	public static void traverse(TreeNode root) {
		if (root == null) return;
		
		System.out.print(root.val + "->");
		traverse(root.left);
		traverse(root.right);
	}
	
	public static void traversePost(TreeNode root) {
		if (root == null) return;
		
		traverse(root.left);
		traverse(root.right);
		System.out.print(root.val + "->");
	}

	public static void main(String[] args) {
		Integer[] arr1 = {-10,9,20,null,null,15,7};
		TreeNode root = buildTree(arr1);
		traversePost(root);
		System.out.println("");
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}

}
