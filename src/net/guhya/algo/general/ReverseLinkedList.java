package net.guhya.algo.general;

public class ReverseLinkedList {
	
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	public static void traverse(ListNode head) {
		if (head == null) return;
		System.out.print(head.val + " -> ");
		traverse(head.next);
	}
	
	public static ListNode reverse(ListNode head) {
		if (head == null) return head;
		ListNode prev = head, current = head.next, next = head.next;
		while (current != null) {
			next = next.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head.next = null;
		head = prev;
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		traverse(l1);
		System.out.println("\n++++++++++");
		l1 = reverse(l1);
		traverse(l1);
		
	}

}
