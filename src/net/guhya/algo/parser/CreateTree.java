package net.guhya.algo.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateTree {

	List<Integer> list;
	
	public CreateTree(List<Integer> list) {
	    this.list = new ArrayList<>(list);
	}
	
	public Node create() {
	    Node root = null;
	    for (int sv : list) {
	        root = createHelper(root, sv);
	    }
	    
	    return root;
	}
	
	private Node createHelper(Node root, int val) {
	    if (root == null) {
	        Node newNode = new Node();
	        newNode.data = val;
	        return newNode;
	    }
	    
	    if (root.data > val) {
	        root.left = createHelper(root.left, val);
	    } else {
            root.right = createHelper(root.right, val);
	    }
	        
	    return root;
	}
	
	public Node sortAndCreate() {
	    Collections.sort(list);
        System.out.println(list);
        
	    Node root = sortAndCreateHelper(0, list.size()-1);
        
	    return root;
    }

    public Node sortAndCreateHelper(int l, int h) {
        if (l > h) return null;
        int m = (l + h) / 2;
        Node node = new Node();
        node.data = list.get(m);
        
        node.left = sortAndCreateHelper(l, m-1);
        node.right = sortAndCreateHelper(m+1, h);
        
        return node;
    }
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
	
	public static void main(String[] args) {
	    Integer[] elements = {8,4,10,9,11,1,5,6};
	    CreateTree pt = new CreateTree(Arrays.asList(elements));
	    Node root = pt.create();
	    
	    System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.right.left.data);
        System.out.println(root.right.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.left.right.right.data);
        System.out.println(root.left.right.left == null);
        
        root = pt.sortAndCreate();
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.left.data);
        System.out.println(root.right.right.data);
        System.out.println(root.right.right.right.data);
        System.out.println(root.right.right.left == null);
	}

}
