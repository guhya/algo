package net.guhya.algo.graph;

public class OneDirectionalAdjMatrixArrayFriendshipMap {

	private AdjMatrixArrayGraph map = new AdjMatrixArrayGraph();
	
	public OneDirectionalAdjMatrixArrayFriendshipMap() {
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
		
		map.removeNode("Mark");
		System.out.println("Mark removed");
		map.printGraph();
		
		/*
		map.removeEdge("Bob", "Alice");
		System.out.println("Edge from Bob to Alice is removed");
		map.printGraph();
		*/
	}

	public static void main(String[] args) {
		new OneDirectionalAdjMatrixArrayFriendshipMap();
	}

}
