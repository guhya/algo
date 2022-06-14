package net.guhya.algo.btree;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int level;
	public int height;
	
	public TreeNode(int data) {
		this.val = data;
	}
	
	public String toString() {
		return "[" + this.val + "|" + this.level + "|" + (this.parent == null ? 0 : this.parent.val) + "|" + height + "]";
	}
}
