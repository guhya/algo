package net.guhya.algo.stack;

public class TheStack {
	
	public Node head;
	
	public class Node {
		
		Node next;
		int data;
		
		public Node(int value) {
			data = value;
		}
		
		@Override
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	public void traverse(Node current) {
		if (current == null) {
			System.out.print("NULL\n");
			return;
		}
		
		System.out.print(current.data + " -> ");
		
		traverse(current.next);
	}
	
	public int getSize() {
		if (head == null) return 0;
		
		Node current = head;
		int c = 1;
		while (current.next != null) {
			current = current.next;
			c++;
		}
		
		return c;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		
		if (head == null) {
			head = node;
			return;
		}
		
		node.next = head;
		head = node;
	}
	
	public int pop() {
		if (head == null) throw new IllegalArgumentException();
		
		int data = head.data;
		head = head.next;
		
		return data;
	}

	public int peek() {
		if (head == null) throw new IllegalArgumentException();
		
		return head.data;
	}

	public static void main(String[] args) {
		
		TheStack stack = new TheStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.traverse(stack.head);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.traverse(stack.head);
	}

}
