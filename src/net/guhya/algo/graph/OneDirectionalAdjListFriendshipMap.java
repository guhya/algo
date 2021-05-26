package net.guhya.algo.graph;

public class OneDirectionalAdjListFriendshipMap {

	private AdjListGraph map = new AdjListGraph();
	
	public OneDirectionalAdjListFriendshipMap() {
		map.addNode("Rob");
		map.addNode("Bob");
		map.addNode("Mark");
		map.addNode("Alice");
		map.addNode("Maria");
		System.out.println("Nodes created");
		map.printGraph();
		
		map.addEdge("Bob", "Alice");
		map.addEdge("Alice", "Maria");
		map.addEdge("Rob", "Bob");
		map.addEdge("Rob", "Mark");
		map.addEdge("Rob", "Maria");
		map.addEdge("Mark", "Alice");
		System.out.println("Nodes connected");
		map.printGraph();
		
		System.out.println("Perform BFS");
		map.bfs("Rob");
		System.out.println("\n");
		
		System.out.println("Perform DFS");
		map.dfs("Rob");
		System.out.println("\n");

		map.removeNode("Mark");
		System.out.println("Mark removed");
		map.printGraph();
		
		map.removeEdge("Bob", "Alice");
		System.out.println("Edge from Bob to Alice is removed");
		map.printGraph();
	}

	public static void main(String[] args) {
		new OneDirectionalAdjListFriendshipMap();
	}

}
