package net.guhya.algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjMatrixListGraph {

	private List<List<Integer>> adjNode = new ArrayList<List<Integer>>();
	private Map<String, Integer> indexMap = new HashMap<>();
	private Map<Integer, String> labelMap = new HashMap<>();

	public AdjMatrixListGraph() {
	}
	
	public List<List<Integer>> addNode(String strNode){
		int index = adjNode.size();
		indexMap.put(strNode, index);
		labelMap.put(index, strNode);
		
		List<Integer> initialCol = new ArrayList<>();
		for(int i=0; i<index; i++) {
			initialCol.add(0);
		}
		
		adjNode.add(initialCol);
		for(List<Integer> row : adjNode) {
			row.add(0);
		}
		
		return adjNode;
	}
		
	public List<List<Integer>> addEdge(String from, String to){
		int fromIndex = indexMap.get(from);
		int toIndex = indexMap.get(to);
		adjNode.get(fromIndex).remove(toIndex);
		adjNode.get(fromIndex).add(toIndex, 1);
		return adjNode;
	}
	
	public List<List<Integer>> removeNode(String strNode){
		int index = indexMap.get(strNode);
		indexMap.remove(strNode);
		labelMap.remove(index);
		
		adjNode.remove(index);
		for(List<Integer> row : adjNode) {
			row.remove(index);
		}
		
		for(int i=index; i<adjNode.size(); i++) {
			labelMap.put(i, labelMap.get(i+1));
			indexMap.put(labelMap.get(i+1), i);
		}
		
		return adjNode;
	}
	
	public List<List<Integer>> removeEdge(String from, String to){
		int fromIndex = indexMap.get(from);
		int toIndex = indexMap.get(to);
		adjNode.get(fromIndex).remove(toIndex);
		adjNode.get(fromIndex).add(toIndex, 0);
		
		return adjNode;
	}
	
	public List<Integer> getNodeChildren(String strLabel) {		
		return adjNode.get(indexMap.get(strLabel));
	}
	
	
	public void printGraph() {
		
		if(adjNode == null || adjNode.isEmpty()) {
			System.out.println("Null graph");
			return;
		}
		
		System.out.print("\t");
		for(int i=0; i<adjNode.size(); i++) {
			System.out.print(labelMap.get(i) + "\t");
		}
		System.out.print("\n");

		int i = 0;
		for(List<Integer> row : adjNode) {
			System.out.print(labelMap.get(i) + "\t");
			i++;
			for(Integer col : row) {
				System.out.print(col);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println("");

	}
	

}
