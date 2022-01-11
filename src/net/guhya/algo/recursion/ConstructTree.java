package net.guhya.algo.recursion;

public class ConstructTree {

	public static class Node {
		public String data;
		public Node left;
		public Node right;
		
		public Node (String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static String constructPost(String inorder, String preorder) {
		if (inorder == null || preorder == null) return "";
		
		int len = inorder.length();
		if (len <= 1) return inorder;
		
		char c = preorder.charAt(0);
		int idx = inorder.indexOf(c);
		if (idx > -1) {
			String left = inorder.substring(0, idx);
			String right = inorder.substring(idx+1, len);
			return constructPost(left, preorder.substring(1)) + constructPost(right, preorder.substring(1)) + c;
		} else {
			return constructPost(inorder, preorder.substring(1));
		}
	}
	
	public static Node constructTree(String inorder, String preorder, Node root) {
		if (inorder == null || preorder == null) return root;
		
		int len = inorder.length();
		if (len <= 1) return new Node(inorder);
		
		char c = preorder.charAt(0);
		int idx = inorder.indexOf(c);
		if (idx > -1) {
			root = new Node(""+c);
			
			String left = inorder.substring(0, idx);
			if (left.length() > 0)	root.left = constructTree(left, preorder.substring(1), root);
			
			String right = inorder.substring(idx+1, len);
			if (right.length() > 0)	root.right = constructTree(right, preorder.substring(1), root);
			
			return root;
			
		} else {
			return constructTree(inorder, preorder.substring(1), root);
		}
	}
	
	
	public static void inorderTraversal(Node root) {
		if (root == null) return;
		
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
		
	}
	
	
	
	public static void main(String[] args) {
		String preorder 	= "ABDECF";
		String inorder 		= "DBEAFC";
		String postorder 	= "DEBFCA";
		
		postorder = constructPost(inorder, preorder);
		System.out.println(postorder);
		
		Node tree = new Node("A");
		tree.left = new Node("B");
		tree.left.left = new Node("C");
		tree.left.right = new Node("D");
		
		System.out.println("++++++++++");
		
		//inorder 	= "CBDA";
		//preorder 	= "ABCD";
		
		Node root = constructTree(inorder, preorder, null);
		System.out.println(root.data);
		System.out.println(root.left.data);
		System.out.println(root.right.data);
		System.out.println(root.left.left.data);
		System.out.println(root.left.right.data);
		System.out.println(root.right.left.data);
	}
}
