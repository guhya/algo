package net.guhya.algo.general;

public class TreeFromPreorderAndInorder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

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

	static int idx = 0;
	public static TreeNode buildTreeUtil(int[] preorder, int[] inorder, int pIdx, int lo, int hi) {
		TreeNode node = new TreeNode(preorder[idx]);
		int i = lo;		
		for (; i<hi; i++) {
			if (preorder[idx] == inorder[i]) {
				break;
			}
		}
		
		idx++;
		
		if (i > lo) {
			node.left = buildTreeUtil(preorder, inorder, pIdx, lo, i-1);
		}
		
		if (i < hi) {
			node.right = buildTreeUtil(preorder, inorder, pIdx, i+1, hi);
		}
		
		return node;
	}
	
	public static void traverse(TreeNode root) {
		if (root == null) return;
		
		System.out.println(root.val);
		traverse(root.left);
		traverse(root.right);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = buildTreeUtil(preorder, inorder, 0, 0, inorder.length-1);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = {-1};
		int[] inorder = {-1};
		
		TreeNode root = buildTree(preorder, inorder);
		traverse(root);
	}

}
