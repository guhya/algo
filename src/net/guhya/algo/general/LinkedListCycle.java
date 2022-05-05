package net.guhya.algo.general;

public class LinkedListCycle {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(0);
		l1.next.next.next = new ListNode(-4);
		l1.next.next.next.next = l1.next;
		System.out.println(hasCycle(l1));
		System.out.println("+++++++++++");
	}

}
