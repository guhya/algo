package net.guhya.algo.general;

public class MergKSortedList {

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
	
    public static ListNode mergeKLists(ListNode[] lists) {
    	int l = 0;
    	for (ListNode list : lists) {
    		ListNode tmp = list;
    		while (tmp != null) {
        		l++;
    			tmp = tmp.next;
    		}
    	}
    	
    	ListNode result = new ListNode(-1);
    	while (l > 0) {
    		int minIndex = 0;
    		while (lists[minIndex] == null) {
    			minIndex++;
    		}
    		
			for (int i=0; i<lists.length; i++) {
				if (lists[i] != null) {
					minIndex = lists[i].val < lists[minIndex].val ? i : minIndex;
				}
			}
			
			ListNode prev = result;
			ListNode tmp = result;
			while (tmp != null) {
				prev = tmp;
				tmp = tmp.next;				
			}
			prev.next = new ListNode(lists[minIndex].val);
			
			lists[minIndex] = lists[minIndex].next;
			l--;
    	}
    	
    	return result.next;
    }	
	 
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode tmp = l2;
		ListNode prev = tmp;
		while (tmp != null) {
			prev = tmp;
			tmp = tmp.next;
		}
		prev.next = new ListNode(4);
		
		ListNode[] lists = {l1, l2, l3};
    	for (ListNode list : lists) {
    		traverse(list);
    		System.out.println("");
    	}
		
    	ListNode merged = mergeKLists(lists);
		traverse(merged);
		
	}

}
