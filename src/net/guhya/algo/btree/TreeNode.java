package net.guhya.algo.btree;

public class TreeNode {
	
	public String data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int level;
	public int height;
	
	public TreeNode(String data) {
		this.data = data;
	}
	
	public String toString() {
		return "[" + this.data + "|" + this.level + "|" + (this.parent == null ? 0 : this.parent.data) + "|" + height + "]";
	}
}
