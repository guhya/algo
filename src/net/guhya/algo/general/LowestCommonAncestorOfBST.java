package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.guhya.algo.btree.TreeNode;
import net.guhya.algo.btree.TreeUtil;

public class LowestCommonAncestorOfBST {
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	List<TreeNode> path1 = new ArrayList<TreeNode>();
    	getPath(root, p, path1);
    	List<TreeNode> path2 = new ArrayList<TreeNode>();
    	getPath(root, q, path2);
    	
    	int i = 0;
    	while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) {
    		i++;
    	}
    	
        return path1.get(i-1);
    }
    
    private static void getPath(TreeNode src, TreeNode dst, List<TreeNode> path) {
		path.add(src);
    	if (src.equals(dst)) return;
    	
    	if (dst.val < src.val) {
    		getPath(src.left, dst, path);
    	} else {
    		getPath(src.right, dst, path);
    	}
    }
    
    
	
	public static void main(String[] args) {
		Integer[] arr1 = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root1 = TreeUtil.buildTree(arr1);
		TreeNode p1 = root1.left;
		TreeNode q1 = root1.right;
		System.out.println(lowestCommonAncestor(root1, p1, q1));
		System.out.println("+++++++++++");
		Integer[] arr2 = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root2 = TreeUtil.buildTree(arr2);
		TreeNode p2 = root2.left;
		TreeNode q2 = root2.left.right;
		System.out.println(lowestCommonAncestor(root2, p2, q2));
		System.out.println("+++++++++++");
		
		final int[] arr3 = {1, 2, 3};
		arr3[0] = 864_000_000 / 1000;
		System.out.println(Arrays.toString(arr3));
	}
}
