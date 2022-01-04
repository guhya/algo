package net.guhya.algo.queue;

public class NodeQueue {
	Node front, rear;
	
	public static class Node {
		
		Node next;
		int data;
		
		public Node(int value) {
			this.data = value;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
		
	}

	public void enqueue(int value) {
		Node newNode = new Node(value);
		
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode; 
		}
	}
	
	public int dequeue() {
		if (front == null) {
			throw new IllegalArgumentException();
		} else {
			int data = front.data;
			
			front = front.next;
			
			return data;
		}
		
		
	}

	public void traverse() {
		Node current = front;
		while (current != null) {
			System.out.print(current + " -> ");
			current = current.next;
		}
		System.out.print("NULL\n");
		
	}
	
	public static void main(String[] args) {
		NodeQueue nq = new NodeQueue();
		nq.traverse();
		nq.enqueue(1);
		nq.enqueue(3);
		nq.enqueue(5);
		nq.enqueue(7);
		nq.traverse();
		System.out.println(nq.dequeue());
		System.out.println(nq.dequeue());
		nq.traverse();
	}

}
