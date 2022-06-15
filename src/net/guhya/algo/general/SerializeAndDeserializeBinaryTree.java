package net.guhya.algo.general;

public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }
    
    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val + ",");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] datas = data.split(",");
        TreeNode root = deserializeUtil(datas);
        return root;
    }   
    
    static int idx = 0;
    /**
     * Instead of using array and counter to get the element, you can use link list
     * @param datas
     * @return
     */
    private TreeNode deserializeUtil(String[] datas) {
        if (idx >= datas.length) return null;
        if ("null".equals(datas[idx])) {
            idx++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(datas[idx]));
        idx++;
        root.left = deserializeUtil(datas);
        root.right = deserializeUtil(datas);
        
        return root;
    }
    
    public static void traverse(TreeNode root) {
        if (root == null) {
            System.out.print("null,");
            return;
        }
        
        System.out.print(root.val + ",");
        traverse(root.left);
        traverse(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
        traverse(root);
        System.out.println();
        String ser = codec.serialize(root);
        System.out.println(ser);
        TreeNode des = codec.deserialize(ser);
        traverse(des);
        System.out.println();
    }

}
