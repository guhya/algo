package net.guhya.algo.general;

import net.guhya.algo.btree.TreeFromArray;
import net.guhya.algo.btree.TreeFromArray.TreeNode;

public class BinaryTreeMaximumPathSum {

	static int maxSum = Integer.MIN_VALUE;
	
	/**
	 * Remember, operation on a tree is the result of any operation done to its sub tree
	 * @param root
	 * @return
	 */
    static int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;
        
        int leftVal = maxPathSumUtil(root.left);
        int rightVal = maxPathSumUtil(root.right);
        
        int maxLeftRight = Math.max(root.val + leftVal, root.val + rightVal);
        int maxRootLeftRight = Math.max(root.val, maxLeftRight);
        int maxAll = Math.max(maxRootLeftRight, root.val + leftVal + rightVal);
        
        maxSum = Math.max(maxSum, maxAll);
        
        return maxRootLeftRight;
    }	
    
	public static void main(String[] args) {
		maxSum = Integer.MIN_VALUE;
		Integer[] arr1 = {-3};
		TreeNode root1 = TreeFromArray.buildTree(arr1);
		maxPathSumUtil(root1);
		System.out.println(maxSum);
		
		System.out.println("++++++++++");
		maxSum = Integer.MIN_VALUE;
		Integer[] arr2 = {-10,9,20,null,null,15,7};
		TreeNode root2 = TreeFromArray.buildTree(arr2);
		maxPathSumUtil(root2);
		System.out.println(maxSum);
		
		System.out.println("++++++++++");
		maxSum = Integer.MIN_VALUE;
		Integer[] arr3 = {5,4,8,11,null,13,4,7,2,null,null,null,1};
		TreeNode root3 = TreeFromArray.buildTree(arr3);
		maxPathSumUtil(root3);
		System.out.println(maxSum);
	}

}
