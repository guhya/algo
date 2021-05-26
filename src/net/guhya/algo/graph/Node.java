package net.guhya.algo.graph;

public class Node {
	
	private String label;
	
	public Node(String label) {
		this.label = label;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Node other = (Node) obj;
		if (!label.equals(other.label)) {
			return false;
		}
		return true;
	}


	public String toString() {
		return label;
	}

}
