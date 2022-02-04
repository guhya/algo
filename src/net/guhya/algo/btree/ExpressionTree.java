package net.guhya.algo.btree;

public class ExpressionTree {
	
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

	public static boolean isOperator(String str) {
		return str.equals("+") || str.equals("-") 
				|| str.equals("*") || str.equals("/");
	}
	
	public static boolean isLeave(Node root) {
		return (root.left == null && root.right == null);
	}

	public static int evaluateExpression(Node root) {
		if (root == null) return 0;
		if (isLeave(root)) {
			int val = Integer.valueOf(root.data);
			return val;
		} else {
			String operator = root.data;
			Node left = root.left;
			Node right = root.right;
			switch (operator) {
				case "+":
					return evaluateExpression(left) + evaluateExpression(right);
				case "-":
					return evaluateExpression(left) - evaluateExpression(right);
				case "*":
					return evaluateExpression(left) * evaluateExpression(right);
				case "/":
					return evaluateExpression(left) / evaluateExpression(right);
			}
			
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		Node root = new Node("+");
		root.left = new Node("*");
		root.right = new Node("-");
		root.left.left = new Node("5");
		root.left.right = new Node("4");
		root.right.left = new Node("100");
		root.right.right = new Node("/");
		root.right.right.left = new Node("20");
		root.right.right.right = new Node("2");
		
		System.out.println(evaluateExpression(root));
	}

}
