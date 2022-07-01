package net.guhya.algo.general;

public class SubtreeOfAnotherTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
    }
    
    public static String traverse(TreeNode root) {
        if (root == null) return "null";
        
        String tree = "";
        tree += root.val + ",";
        tree += traverse(root.left) + ",";
        tree += traverse(root.right);
        
        return tree;
    }

    public static String postTraverse(TreeNode root) {
        if (root == null) return "null";
        
        String tree = "";
        tree += traverse(root.left) + ",";
        tree += traverse(root.right) + ",";
        tree += root.val;
        
        return tree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        
        TreeNode matchRoot = new TreeNode(3);
        matchRoot.left = new TreeNode(4);
        matchRoot.right = new TreeNode(5);
        matchRoot.left.left = new TreeNode(1);
        matchRoot.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        
        System.out.println(postTraverse(root));
        System.out.println(postTraverse(subRoot));
        System.out.println(postTraverse(matchRoot));
    }

}
