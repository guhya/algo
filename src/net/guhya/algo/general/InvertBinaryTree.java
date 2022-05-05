package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

    public static TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	
    	invertTree(root.left);
    	invertTree(root.right);
    	
        return root;
    }
    
    
    public static void inorder(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	
    	inorder(root.left, list);
    	list.add(root.val);
    	inorder(root.right, list);
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		System.out.println(list);
		
		root = invertTree(root);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		
		
	}

}
