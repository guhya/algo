package net.guhya.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AdjListGraph {

	private Map<Node, List<Node>> adjNode = new HashMap<>();
	
	public AdjListGraph() {
	}
	
	public Map<Node, List<Node>> addNode(String strNode){
		if(strNode == null) return adjNode;
		Node node = new Node(strNode);
		adjNode.put(node, new ArrayList<Node>());

		return adjNode;
	}
		
	public Map<Node, List<Node>> addEdge(String from, String to){
		Node n1 = new Node(from);
		Node n2 = new Node(to);
		adjNode.get(n1).add(n2);
		
		return adjNode;
	}
	
	public Map<Node, List<Node>> removeNode(String strNode){
		Node node = new Node(strNode);
		adjNode.remove(node);
		
		for(Map.Entry<Node, List<Node>> entry : adjNode.entrySet()) {
			entry.getValue().remove(node);
		}
		
		return adjNode;
	}
	
	public Map<Node, List<Node>> removeEdge(String from, String to){
		Node n1 = new Node(from);
		Node n2 = new Node(to);
		adjNode.get(n1).remove(n2);
		
		return adjNode;
	}
	
	public List<Node> getNodeChildren(String strLabel) {		
		return adjNode.get(new Node(strLabel));
	}
	
	
	public void printGraph() {
		
		if(adjNode == null || adjNode.isEmpty()) {
			System.out.println("Null Graph");
			return;
		}
		
		for(Map.Entry<Node, List<Node>> entry : adjNode.entrySet()) {
			System.out.print(entry.getKey());
			System.out.print("\t : ");
			System.out.print(entry.getValue());
			System.out.print("\n");
		}
		System.out.println("");

	}
	
	public void bfs(String startNode) {
		Set<Node> visited = new LinkedHashSet<>();
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(startNode));
		while (!q.isEmpty()) {
			Node n = q.poll();
			visited.add(n);
			List<Node> children = adjNode.get(n);
			for(Node c : children) {
				q.add(c);
			}
		}
		
		System.out.println(visited);
	}
	
	public void dfs(String startNode) {
		Set<Node> visited = new LinkedHashSet<>();
		
		Stack<Node> s = new Stack<>();
		s.push(new Node(startNode));
		while (!s.isEmpty()) {
			Node n = s.pop();
			visited.add(n);
			List<Node> children = adjNode.get(n);
			for(Node c : children) {
				if(!visited.contains(c)) {
					s.push(c);
				}
			}
		}
		
		System.out.println(visited);
	}	

}
