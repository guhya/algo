package net.guhya.algo.general;

public class RemoveFromBehind {

	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	static int counter = 0;
	static int size = 0;
	static ListNode prev = null;
	public static void remove(ListNode head, int n) {
		if (head == null) return;
		
		size++;
		remove(head.next, n);
		counter++;
		if (counter-1 == n) {
			prev = head.next;
			head.next = prev.next;
		}
		
	}
	
	
	public static ListNode removeElement(ListNode head, int n) {
		int size = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			size++;
		}
		
		if (n == size) {
			head = head.next;
		} else {
			tmp = head;
			for (int i=1; i<size-n; i++) {
				tmp = tmp.next;
			}
			tmp.next = tmp.next.next;
		}
		
		return head;
	}
	
	public static void traverse(ListNode head) {
		if (head == null) return;
		System.out.print(head.val + " -> ");
		traverse(head.next);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		
		head = removeElement(head, 3);
		traverse(head);
	}

}
