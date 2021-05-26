package net.guhya.algo.graph;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FindPath {
	
	static class Node {
		int i;
		int j;
		int distance = 0;
		Node(int vi, int vj){
			i = vi;
			j = vj;
		}
		
		public String toString(){
			return "["+i+"]["+j+"]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			Node other = (Node) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
		
		
	}

	static boolean bfsFindPath(int[][] arr, int[] start, int[] end) {
		Map<Node, Node> routeMap = new LinkedHashMap<>();
		int[][] visitedArr = new int[arr.length][arr[0].length];
		
		Set<Node> visited = new HashSet<>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start[0], start[1]));
		
		while(!q.isEmpty()) {
			Node tile = q.poll();
			
			//Mark as visited
			if(!visited.contains(tile)) {
				visited.add(tile);
				visitedArr[tile.i][tile.j] = 1;
				
				//If tile is end destination, return true
				if(tile.i == end[0] && tile.j == end[1]) {
					for(int i=0; i<visitedArr.length; i++) {
			    		//System.out.print(visitedArr[i] + "\t");
						for(int j=0; j<visitedArr[i].length; j++) {
			        		System.out.print(visitedArr[i][j] + "\t");        		
						}
			    		System.out.print("\n");
					}
					
					LinkedList<Node> route = new LinkedList<>();
					route.addFirst(tile);
					Node rp = routeMap.get(tile);
					while(rp != null) {
						route.addFirst(rp);
						rp = routeMap.get(rp);
					}
					System.out.println("Found, shortest distance = [" + tile.distance + "] " + route);
					return true;
				}
			}
			
			//Get all possible move from here
			{
				int up = (tile.i-1 < 0) ? -1 : arr[tile.i-1][tile.j];
				int right = (tile.j+1 >= arr[tile.i].length) ? -1 :arr[tile.i][tile.j+1];
				int down = (tile.i+1 >= arr.length) ? -1 : arr[tile.i+1][tile.j];
				int left = (tile.j-1 < 0) ? -1 : arr[tile.i][tile.j-1];
				//System.out.println("["+up+"]["+right+"]["+down+"]["+left+"]");
				
				if(up > -1) {
					Node n = new Node(tile.i-1, tile.j);
					n.distance = tile.distance+1;
					if(!visited.contains(n)) {
						q.add(n);
						routeMap.put(n, tile);
					}
				}
				if(right > -1) {
					Node n = new Node(tile.i, tile.j+1);
					n.distance = tile.distance+1;
					if(!visited.contains(n)) {
						q.add(n);
						routeMap.put(n, tile);
					}
				}
				if(down > -1) {
					Node n = new Node(tile.i+1, tile.j);
					n.distance = tile.distance+1;
					if(!visited.contains(n)) {
						q.add(n);
						routeMap.put(n, tile);
					}
				}
				if(left > -1) {
					Node n = new Node(tile.i, tile.j-1);
					n.distance = tile.distance+1;
					if(!visited.contains(n)) {
						q.add(n);
						routeMap.put(n, tile);
					}
				}
			}
			
		}
		
		//We explored all possible path, no luck
		return false;
		
	}
	
	static boolean dfsFindPath(int[][] arr, int[] start, int[] end) {
		Map<Node, Node> routeMap = new LinkedHashMap<>();
		int[][] visitedArr = new int[arr.length][arr[0].length];
		
		Set<Node> visited = new LinkedHashSet<>();
		Stack<Node> s = new Stack<>();
		s.push(new Node(start[0], start[1]));
		while(!s.isEmpty()) {
			Node tile = s.pop();
			
			//Mark as visited
			if(!visited.contains(tile)) {
				visited.add(tile);
				visitedArr[tile.i][tile.j] = 1;
				
				//If tile is end destination, return true
				if(tile.i == end[0] && tile.j == end[1]) {
					for(int i=0; i<visitedArr.length; i++) {
			    		//System.out.print(visitedArr[i] + "\t");
						for(int j=0; j<visitedArr[i].length; j++) {
			        		System.out.print(visitedArr[i][j] + "\t");        		
						}
			    		System.out.print("\n");
					}
					LinkedList<Node> route = new LinkedList<>();
					route.addFirst(tile);
					Node rp = routeMap.get(tile);
					while(rp != null) {
						route.addFirst(rp);
						rp = routeMap.get(rp);
					}
					System.out.println("Found a path " + route);
					return true;
				}
			}
			
			//Get all possible move from here
			{
				int up = (tile.i-1 < 0) ? -1 : arr[tile.i-1][tile.j];
				int right = (tile.j+1 >= arr[tile.i].length) ? -1 :arr[tile.i][tile.j+1];
				int down = (tile.i+1 >= arr.length) ? -1 : arr[tile.i+1][tile.j];
				int left = (tile.j-1 < 0) ? -1 : arr[tile.i][tile.j-1];
				//System.out.println("["+up+"]["+right+"]["+down+"]["+left+"]");
				
				if(up > -1) {
					Node n = new Node(tile.i-1, tile.j);
					if(!visited.contains(n)) {
						s.push(n);
						routeMap.put(n, tile);
					}
				}
				if(right > -1) {
					Node n = new Node(tile.i, tile.j+1);
					if(!visited.contains(n)) {
						s.push(n);
						routeMap.put(n, tile);
					}
				}
				if(down > -1) {
					Node n = new Node(tile.i+1, tile.j);
					if(!visited.contains(n)) {
						s.push(n);
						routeMap.put(n, tile);
					}
				}
				if(left > -1) {
					Node n = new Node(tile.i, tile.j-1);
					if(!visited.contains(n)) {
						s.push(n);
						routeMap.put(n, tile);
					}
				}
			}
			
		}
		
		
		//We explored all possible path, no luck
		return false;
		
	}	
	
	static boolean dfsFindPathRecursively(int[][] arr, int[] start, int[] end, int[][] visitedArr, Map<Node, Node> routeMap) {
		Node tile = new Node(start[0], start[1]);
		visitedArr[tile.i][tile.j] = 1;

		//If tile is end destination, return true
		if(tile.i == end[0] && tile.j == end[1]) {
			for(int i=0; i<visitedArr.length; i++) {
	    		//System.out.print(visitedArr[i] + "\t");
				for(int j=0; j<visitedArr[i].length; j++) {
	        		System.out.print(visitedArr[i][j] + "\t");        		
				}
	    		System.out.print("\n");
			}
			LinkedList<Node> route = new LinkedList<>();
			route.addFirst(tile);
			Node rp = routeMap.get(tile);
			while(rp != null) {
				route.addFirst(rp);
				rp = routeMap.get(rp);
			}
			System.out.println("Recursively found a path " + route);
			return true;
		}
		
		//Get all possible move from here
		{
			int up = (tile.i-1 < 0) ? -1 : arr[tile.i-1][tile.j];
			int right = (tile.j+1 >= arr[tile.i].length) ? -1 :arr[tile.i][tile.j+1];
			int down = (tile.i+1 >= arr.length) ? -1 : arr[tile.i+1][tile.j];
			int left = (tile.j-1 < 0) ? -1 : arr[tile.i][tile.j-1];
			//System.out.println("["+up+"]["+right+"]["+down+"]["+left+"]");
			
			if(up > -1 && visitedArr[tile.i-1][tile.j] != 1) {
				int[] newStart = new int[] {tile.i-1, tile.j};
				routeMap.put(new Node(tile.i-1, tile.j), tile);
				if(dfsFindPathRecursively(arr, newStart, end, visitedArr, routeMap)) {
					return true;
				}
			}
			if(right > -1 && visitedArr[tile.i][tile.j+1] != 1) {
				int[] newStart = new int[] {tile.i, tile.j+1};
				routeMap.put(new Node(tile.i, tile.j+1), tile);
				if(dfsFindPathRecursively(arr, newStart, end, visitedArr, routeMap)) {
					return true;
				}
			}
			if(down > -1 && visitedArr[tile.i+1][tile.j] != 1) {
				int[] newStart = new int[] {tile.i+1, tile.j};
				routeMap.put(new Node(tile.i+1, tile.j), tile);
				if(dfsFindPathRecursively(arr, newStart, end, visitedArr, routeMap)) {
					return true;
				}
			}
			if(left > -1 && visitedArr[tile.i][tile.j-1] != 1) {
				int[] newStart = new int[] {tile.i, tile.j-1};
				routeMap.put(new Node(tile.i, tile.j-1), tile);
				if(dfsFindPathRecursively(arr, newStart, end, visitedArr, routeMap)) {
					return true;
				}
			}
		}
		
		return false;		
	}		
	
	public static void main(String[] args) {
        int arr[][] = 
        	  { {  0,  0,  0,  0,  0 }, 
                { -1, -1,  0, -1, -1 }, 
                {  0,  0,  0, -1,  0 }, 
                { -1,  0,  0,  0, -1 }, 
                {  0, -1,  0,  0,  0 }
               }; 
        int[][] visitedArr = new int[arr.length][arr[0].length];
		
		int[] start = new int[] {0,0};
		int[] end = new int[] {4,4};
		System.out.println(bfsFindPath(arr, start, end));
		System.out.println("---------");
		System.out.println(dfsFindPath(arr, start, end));
		System.out.println("---------");
		System.out.println(dfsFindPathRecursively(arr, start, end, visitedArr, new LinkedHashMap<>()));
		
	}

}
