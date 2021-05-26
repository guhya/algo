package net.guhya.algo.graph;

import java.util.HashMap;
import java.util.Map;

public class AdjMatrixArrayGraph {

	private int initialCapacity = 4;
	private int[][] adjNode;
	private int numberOfItem = 0;
	private Map<String, Integer> indexMap = new HashMap<>();
	private Map<Integer, String> labelMap = new HashMap<>();

	public AdjMatrixArrayGraph() {
		adjNode = new int[initialCapacity][initialCapacity];
	}
	
	public AdjMatrixArrayGraph(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		adjNode = new int[initialCapacity][initialCapacity];
	}
	
	public int[][] addNode(String strNode){
		int index = numberOfItem;
		indexMap.put(strNode, index);
		labelMap.put(index, strNode);
		
		if(numberOfItem >= adjNode.length) {
			int[][] temp = new int[adjNode.length*2][adjNode.length*2];
			for(int i=0; i<adjNode.length; i++) {
				for(int j=0; j<adjNode.length; j++) {
					temp[i][j] = adjNode[i][j];
				}
			}
			adjNode = temp;
		}
		
		numberOfItem++;
		
		return adjNode;
	}
		
	public int[][] addEdge(String from, String to){
		int fromIndex = indexMap.get(from);
		int toIndex = indexMap.get(to);
		adjNode[fromIndex][toIndex] = 1;
		return adjNode;
	}
	
	public int[][] removeNode(String strNode){
		int index = indexMap.get(strNode);
		indexMap.remove(strNode);
		labelMap.remove(index);
		
		for(int i=index; i<numberOfItem; i++) {
			adjNode[i] = adjNode[i+1];
		}
		
		for(int i=0; i<numberOfItem; i++) {
			for(int j=index; j<numberOfItem; j++) {
				adjNode[i][j] = adjNode[i][j+1];
			}
		}
		
		for(int i=index; i<numberOfItem; i++) {
			labelMap.put(i, labelMap.get(i+1));
			indexMap.put(labelMap.get(i+1), i);
		}

		numberOfItem--;
		return adjNode;
	}
	
	public int[][] removeEdge(String from, String to){
		int fromIndex = indexMap.get(from);
		int toIndex = indexMap.get(to);
		adjNode[fromIndex][toIndex] = 0;
		
		return adjNode;
	}
	
	public int[] getNodeChildren(String strLabel) {		
		return adjNode[indexMap.get(strLabel)];
	}
	
	
	public void printGraph() {
		
		if(adjNode == null || numberOfItem == 0) {
			System.out.println("Null graph");
			return;
		}
		
		System.out.print("\t");
		for(int i=0; i<numberOfItem; i++) {
			System.out.print(labelMap.get(i) + "\t");
		}
		System.out.print("\n");

		for(int i=0; i<numberOfItem; i++) {
			System.out.print(labelMap.get(i) + "\t");
			for(int j=0; j<numberOfItem; j++) {
				System.out.print(adjNode[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println("");

	}
	

}
