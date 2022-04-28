package net.guhya.algo.general;

public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode findPreMid(ListNode head) {
		ListNode slow = head, fast = head, pre = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return pre;
	}
	
	public static void reorder(ListNode head) {
		ListNode preMid = findPreMid(head);
		ListNode prev = preMid, current = prev.next, next = current;
		while (current != null) {
			next = next.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		if (preMid.next == null) return;
		preMid.next.next = null;
		preMid.next = prev;
		
		ListNode l2 = preMid.next;
		preMid.next = null;
		merge(head, l2);
	}
	
	public static void merge(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			ListNode l1Next = l1.next;
			ListNode l2Next = l2.next;
			l1.next = l2;
			if (l1Next == null) break;
			l2.next = l1Next;
			l1 = l1Next;
			l2 = l2Next;
		}
	}

	public static void traverse(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		traverse(l1);
		reorder(l1);
		traverse(l1);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(3);
		reorder(l2);
		traverse(l2);
		
		/*
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(4);
		n1.next.next.next = new ListNode(3);
		ListNode n2 = new ListNode(6);
		n2.next = new ListNode(5);
		traverse(n1);
		traverse(n2);
		merge(n1, n2);
		traverse(n1);
		*/
	}

}
