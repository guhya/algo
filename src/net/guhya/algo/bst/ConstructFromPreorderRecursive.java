package net.guhya.algo.bst;

import net.guhya.algo.btree.Tree;
import net.guhya.algo.btree.TreeNode;

public class ConstructFromPreorderRecursive {

	public static TreeNode construct(int[] arr, int l, int h, TreeNode root) {
		
		if (root == null) {
			root = new TreeNode(String.valueOf(arr[l]));
		} 
		
		int i = findMax(arr, l, h);
		
		if (i !=-1 && i != l+1) {
			l++;
			root.left = new TreeNode(String.valueOf(arr[l]));
			construct(arr, l, i-1, root.left);
		}
		
		if (i > l) {
			root.right = new TreeNode(String.valueOf(arr[i]));
			construct(arr, i, h, root.right);
		}
		
		return root;
	}
	
	private static int findMax(int[] arr, int l, int h) {
		int i = 0;
		for (i=l; i<=h; i++) {
			if (arr[i] > arr[l]) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 1, 7, 40, 50};
		TreeNode root = construct(arr, 0, arr.length-1, null);
		
		int[] arr2 = {8, 3, 1, 6, 4, 7, 10, 14, 13};
		TreeNode root2 = construct(arr2, 0, arr2.length-1, null);
		
		Tree.toArray(root);
		Tree.toArray(root2);
	}

}
