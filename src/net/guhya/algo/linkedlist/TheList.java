package net.guhya.algo.linkedlist;

import java.util.HashSet;

import net.guhya.algo.btree.Tree;
import net.guhya.algo.btree.TreeNode;

public class TheList {
	
	public Node head;
	
	public static class Node {
		
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
	
	public void insertAt(int index, int value) {
		Node node = new Node(value);
		int size = getSize();
		
		if (index > size) throw new IllegalArgumentException();
		if (index == 0) {
			insert(value);
			return;
		}
		
		if (index == size) {
			append(value);
			return;
		}
		
		Node current = head;
		int i = 0;
		while (i < (index-1)) {
			current = current.next;
			i++;
		}
		
		node.next = current.next;
		current.next = node;
	}

	public void insert(int value) {
		Node node = new Node(value);
		
		if (head == null) {
			head = node;
			return;
		}
		
		node.next = head;
		head = node;
	}
	
	public void append(int value) {
		Node node = new Node(value);
		
		if (head == null) {
			head = node;
			return;
		}
		
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = node;
	}
	
	public void reverse(Node head) {
		if (head == null || head.next == null) return;
		
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		this.head = prev;
	}
	
	public void printMid(Node head) {
		if (head == null || head.next == null) return;

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		System.out.println(slow);
	}
	
	public boolean isLoop(Node head) {
		if (head == null) return false;
		
		Node current = head;
		Node prev = null;
		HashSet<Integer> tracker = new HashSet<>();
		while (current != null) {
			if (tracker.contains(current.data)) {
				System.out.println("Loop " + current + "->" + tracker + " X " + prev);
				return true;
			}
			
			tracker.add(current.data);
			prev = current;
			current = current.next;
		}
		
		return false;
	}
	
	public static void util( ) {
		TheList tl = new TheList();
		tl.insert(5);
		tl.append(6);
		tl.insertAt(1, 9);
		tl.insertAt(0, 10);
		
		tl.traverse(tl.head);
		tl.reverse(tl.head);
		tl.traverse(tl.head);
		tl.printMid(tl.head);
		
		
		System.out.println("Size : " + tl.getSize());
		
		Node branch = tl.head.next;
		tl.head.next.next.next.next = branch;		
		
		if (!tl.isLoop(tl.head)) tl.traverse(tl.head);
	}

	private static Node findMid(Node head, Node tail) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			if (fast == tail || fast.next == tail) break;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	private static Node findBeforeTail(Node head, Node tail) {
		Node current = head;
		while (current != null && current != tail && current.next != tail) {
			current = current.next;
		}
		
		return current;
	}
	
	
	private static TreeNode constructBstFromList(Node head, Node tail, Node afterTail) {
		
		if (head == afterTail) {
			return null;
		}
		
		Node mid = findMid(head, tail);
		TreeNode node = new TreeNode(String.valueOf(mid.data));
		
		Node leftHead = head;
		Node leftTail = findBeforeTail(head, mid);
		Node afterLeftTail = mid;
		
		Node rightHead = mid.next;
		Node rightTail = tail;
		Node afterRightTail = rightTail == null ? null : rightTail.next;
		
		node.left = constructBstFromList(leftHead, leftTail, afterLeftTail);
		node.right = constructBstFromList(rightHead, rightTail, afterRightTail);

		return node;
	}
	
	public static void main(String[] args) {
		TheList tl = new TheList();
		tl.append(1);
		tl.append(2);
		tl.append(3);
		tl.append(4);
		tl.append(5);
		tl.append(6);
		tl.append(7);
		
		tl.traverse(tl.head);
		
		Node tail = findBeforeTail(tl.head, null);
		TreeNode root = constructBstFromList(tl.head, tail, null);
		Tree.toArray(root);
	}
	

}
