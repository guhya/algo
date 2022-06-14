package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CloneGraph {

	public static class Node {
		public int val;
		public List<Node> neighbors;
		public Node(int val) {
			this.val = val;
			this.neighbors = new ArrayList<>();
		}
		public String toString() {
			return String.valueOf(this.val);
		}
	}
	
	public static void traverse(Node node) {
		StringBuilder sb = new StringBuilder();
		Set<Node> visited = new HashSet<>();
		LinkedList<Node> q = new LinkedList<>();
		q.add(node);
		visited.add(node);
		while (!q.isEmpty()) {
			Node n = q.removeFirst();
			sb.append(n.neighbors + ",");
			for (Node sn : n.neighbors) {
				if (!visited.contains(sn)) {
					q.add(sn);
					visited.add(sn);
				}
			}
		}
		
		String s = sb.toString();
		s = s.length() > 1 ? s.substring(0, s.length()-1) : "";
		
		System.out.println(s);
	}
	
	/**
	 * To clone a graph, do a BFS on old graph. Meanwhile we put newly created node at map
	 * for getting a reference later.
	 * Everytime we encounter a new node in the neighbor list, crate a node and put in the map.
	 * If we encounter visited node, get the node from the map.
	 * @param node
	 * @return
	 */
    public static Node cloneGraph(Node node) {
        Node newNode = new Node(node.val);
		HashMap<Integer, Node> visited = new HashMap<>();
		LinkedList<Node> q = new LinkedList<>();
		q.add(node);
		visited.put(newNode.val, newNode);
		while (!q.isEmpty()) {
			Node n = q.removeFirst();
			for (Node sn : n.neighbors) {
				Node newSn = null;
				if (!visited.containsKey(sn.val)) {
					newSn = new Node(sn.val);
					q.add(sn);
					visited.put(newSn.val, newSn);
				} else {
					newSn = visited.get(sn.val);
				}
				visited.get(n.val).neighbors.add(newSn);
			}
		}
        return newNode;
    }
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.neighbors.add(n2);
		n1.neighbors.add(n4);
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n3.neighbors.add(n2);
		n3.neighbors.add(n4);
		n4.neighbors.add(n1);
		n4.neighbors.add(n3);
		traverse(n1);
		Node nn1 = cloneGraph(n1);
		traverse(nn1);
		System.out.println("+++++++++++");
		Node n5 = new Node(1);
		traverse(n5);
		Node nn5 = cloneGraph(n5);
		traverse(nn5);
	}

}
