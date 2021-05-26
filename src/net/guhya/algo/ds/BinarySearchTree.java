package net.guhya.algo.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node add(int val) {
		root = recurseAdd(root, val, null);
		return root;
	}
	
	public Node recurseAdd(Node node, int val, Node parent) {
		if(node == null) {
			node = new Node(val);
			return node;
		}
		
		if(val > node.value) {
			Node newNode = recurseAdd(node.right, val, node);
			newNode.parent = node;
			node.right = newNode;
		}else {
			Node newNode = recurseAdd(node.left, val, node); 
			newNode.parent = node;
			node.left = newNode;
		}
		
		return node;
	}

	public Node find(Node start, int val) {
		if(start == null) return null;
		if(start.value == val) return start;
		
		if(val > start.value)
			return find(start.right, val);
		else
			return find(start.left, val);
		
	}
	
	public List<Node> findShortestPath(int start, int end){
		List<Integer> visited = new ArrayList<>();
		Map<Integer, Node> routeMap = new HashMap<>(); 
		List<Node> path = new ArrayList<>();
		Node startNode = find(root, start); 
		
		Queue<Node> q = new LinkedList<>();
		q.add(startNode);
		while(!q.isEmpty()) {
			Node n = q.poll();
			visited.add(n.value);
			if(n.value == end) {
				path.add(n);
				Node p = routeMap.get(n.value);
				while(p != null) {
					path.add(p);
					p = routeMap.get(p.value);
				}
				Collections.reverse(path);
				System.out.println("Found path at distance " + n.distance);
				break;
			}
			
			if(n.left != null) {
				if(!visited.contains(n.left.value)) {
					n.left.distance = n.distance + 1;
					routeMap.put(n.left.value, n);
					q.add(n.left);
				}
			}
			if(n.right != null) {
				if(!visited.contains(n.right.value)) {
					n.right.distance = n.distance + 1;
					routeMap.put(n.right.value, n);
					q.add(n.right);
				}
			}
			if(n.parent != null) {
				if(!visited.contains(n.parent.value)) {
					n.parent.distance = n.distance + 1;
					routeMap.put(n.parent.value, n);
					q.add(n.parent);
				}
			}
			
		}
		
		return path;
	}
	
	public void print() {
		if(root == null) return;
		List<Node> nodeList = new ArrayList<>();
		
		//Save complete tree in an array, null node is substituted with -1 
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int emptyCount = 0, count = 0, nextGrow = 2, toCheck = 1;
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			count++;
			
			if(n.value == -1) { 
				emptyCount++;
			} else { 
				emptyCount = 0;
			}
			
			if(count == nextGrow) {
				toCheck = nextGrow;
				nextGrow *= 2;
			}
			
			nodeList.add(n);
			if(emptyCount == toCheck) {
				for(int i=count+1; i<nextGrow; i++) {
					nodeList.add(n);
				}
				break;
			}
			
			if(n.left != null) 
				q.add(n.left);
			else 
				q.add(new Node(-1));
				
			if(n.right != null) 
				q.add(n.right);
			else
				q.add(new Node(-1));

		}
		
		//Visualize tree
		System.out.println(nodeList);
		int mid = nodeList.size() / 2 + 1;
		String format = "%8.8s";
		int v = 0;
		for(int i=1; i<=nodeList.size(); i = i*2) { // 1, 2, 4, 8
			System.out.print(getLine(" ", mid));
			for(int j=1; j<=i; j++) {
				Node node = nodeList.get(v);
				String val = node.value > -1 ? String.valueOf(node.value) : " ";
				System.out.printf(format, val + "    ");
				if(j!=i) System.out.print(getLine(" ", (mid*2)-1));
				v++;
			}
			mid = mid / 2;
			System.out.print("\n");
		}

	}
	
	private String getLine(String str, int number) {
		String fill = "";
		for(int k=1; k<=8; k++) {
			fill += str;
		}

		String result = fill;
		for(int k=1; k<=number; k++) {
			result += fill;
		}
		return result;
	}
	
	public class Node {
		int value;
		Node left;
		Node right;
		Node parent;
		int distance;
		
		public Node(int val) {
			value = val;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			String nl = (left != null) ? "("+left.value+")" : "(-)";
			String nr = (right != null) ? "("+right.value+")" : "(-)";
			String p = (parent != null) ? "["+parent.value+"]" : "(-)";
			builder.append(nl);
			builder.append(value);
			builder.append(nr);
			builder.append(p);
			return builder.toString();
		}
	
	}

	public static void main(String[] args) {
		System.out.println("Binary search tree");
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(3);
		bst.add(10);
		bst.add(20);
		bst.add(2);
		bst.add(4);
		bst.print();
		List<Node> path = bst.findShortestPath(2, 20);
		System.out.println(path);
		
	}

}
