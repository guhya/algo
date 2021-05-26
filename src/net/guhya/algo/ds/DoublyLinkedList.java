package net.guhya.algo.ds;

public class DoublyLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public Node addLast(int value) {
		return add(value, size);
	}
	
	public Node addFirst(int value) {	
		return add(value, 0);
	}

	public Node add(int value) {	
		return addLast(value);
	}
	
	/**
	 * Adding element to the list, there are multiple cases : <br>
	 * 1. When index is 0, it means adding to the beginning of the list.<br>
	 *    In this case, simply set the 'next' pointer of the new node to the 
	 *    first node. And point 'first' and 'last' pointer to the newly added 
	 *    node O(1).<br><br>
	 *      
	 * 2. When index equals to list size, it means adding to the end of the list
	 *    Simply follow 'last' pointer to get the node, and set its 'next' 
	 *    pointer to the new node.<br> 
	 *    Then adjust 'last' pointer to point to this newly added node 
	 *    afterwards.<br>
	 *    Normally we need to traverse list and visit node one by one until we
	 *    arrives at the last node O(n), but because we keep track of the last 
	 *    node in 'last' pointer, we can avoid that O(1).<br><br> 
	 *    
	 * 3. When 0 < index < list size, at this position it is guaranteed 
	 *    that the new node will have predecessor and successor.<br>  
	 *    First, visit the node one by one n times until the desired location is
	 *    found, we'll call it 'current' pointer.<br>
	 *    Keep track of the node predecessor by saving it in a pointer
	 *    named 'before'. <br>
	 *    Then set the 'next' pointer of predecessor to this newly added node.
	 *    Last, we set the 'next' pointer of this newly added node to the node 
	 *    'current' pointer points to.<br><br>
	 * 
	 * Increase the size of the list by 1.
	 *     
	 * @param value to be added to the list
	 * @param index, where to place it
	 * @return the linked list itself
	 */
	public Node add(int value, int index) {
		if(index < 0 || index > size) 
			throw new IndexOutOfBoundsException("Index out of range");
			
		Node newNode = new Node(value);
		if(index == 0) {
			newNode.next = first;
			if(first != null) first.prev = newNode; 
			first = newNode;
			if(last == null) last = newNode;
			
		} else if(index == size) {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
			
		} else {
			Node current = first;
			int i = 0;
			while(i < index) {
				current = current.next;
				i++;
			}
			current.prev.next = newNode;
			newNode.prev = current.prev;
			newNode.next = current;
			current.prev = newNode;
		}
		size++;
		
		return first;
	}
	
	public Node removeFirst() {
		return remove(0);
	}
	
	public Node removeLast() {
		return remove(size-1);
	}

	/**
	 * Removing element from the list, there are multiple cases : <br>
	 * 1. When size of list is 1, simply set the 'first' and 'last' pointer to
	 *    null O(1).<br><br>
	 *      
	 * 2. When index equals to 0, it means removing the first node.<br>
	 *    Simply set 'first' pointer to the deleted node successor O(1).<br><br> 
	 *    
	 * 3. Removing element when list has more than one element and it is not 
	 *    removing the first node.<br>
	 *    Traverse the list and get the node at index position, saved in in a
	 *    pointer called 'current'. Next, we will remove this node by linking
	 *    it's predecessor ('before' pointer) to it's successor.<br>  
	 *     
	 * Decrease the size of the list by 1. If the size of the list is 1 after
	 * that, set the last node to the first node. 
	 * 
	 * @param value to be added to the list
	 * @param index, where to place it
	 * @return the deleted node
	 */
	public Node remove(int index) {
		/* Simply reject operation on invalid index */
		if(index < 0 || index >= size) 
			throw new IndexOutOfBoundsException("Index out of range");
		
		if(size == 1) {
			Node deletedNode = first;
			first = null;
			last = first;
			size--;
			
			return deletedNode;
		}
		
		if(index == 0) {
			Node deletedNode = first;
			first = first.next;
			first.prev = null;
			size--;
			
			return deletedNode;
		}
		
		Node current = first;
		int i = 0;
		while(i < index) {
			current = current.next;
			i++;
		}
		
		if (current.next != null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		} else {
			current.prev.next = null;
		}
		
		size--;
		if(size <= 1)
			last = first;
		
		return current;
	}
	
	public Node reverse() {
		if(size <= 1) 
			return first;
		
		Node current = first;
		Node after = null;
		last = first;
		while(current != null) {
			after = current.next;
			
			Node tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			first = current;
			
			current = after;
		}
		
		return first;
	}
	
	public void print() {
		
		Node current = first;
		System.out.print("[");
		while(current != null) {
			String node = "";
			node += (current.prev == null) ? "" : "<-";
			node += current;
			node += (current.next == null) ? "" : "->";
			System.out.print(node);
			
			current = current.next;
		}
		System.out.print("]\n");
	}
	

	public class Node {
		int value;
		Node next;
		Node prev;
		
		public Node(int value){
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			
			if (prev != null) 
				builder.append("(" + prev.value + ")");
			else 
				builder.append("(-)");

			builder.append(value);
			
			if (next != null) 
				builder.append("(" + next.value + ")");
			else 
				builder.append("(-)");
			
			return builder.toString();
		}
	}
	

	public static void main(String[] args) {	
		System.out.println("Doubly linked list");
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.print("Added default    \t");
		list.add(2);
		list.print();
		System.out.print("Added at first   \t");
		list.addFirst(1);
		list.print();
		System.out.print("Added at default \t"); 
		list.add(5);
		list.print();
		System.out.print("Added at last    \t"); 
		list.addLast(10);
		list.print();
		System.out.print("Added at index 2 \t"); 
		list.add(3, 2);
		list.print();
		System.out.print("Added at default \t"); 
		list.add(11);
		list.print();
		System.out.print("Added at default \t");
		list.add(22);
		list.print();

		System.out.print("\n");
		list.reverse();
		System.out.print("Reverse list      \t");
		list.print();
		list.reverse();
		System.out.print("Reverse list again  \t");
		list.print();
		System.out.print("\n");

		System.out.print("Deleted index 6 [" + list.remove(6) + "]   \t");
		list.print();
		System.out.print("Deleted index 4 [" + list.remove(4) + "]   \t");
		list.print();
		System.out.print("Deleted index 0 [" + list.remove(0) + "]   \t");
		list.print();
		System.out.print("Deleted Last    [" + list.removeLast() + "]   \t");
		list.print();
		System.out.print("Deleted index 1 [" + list.remove(1) + "]   \t");
		list.print();
		System.out.print("Deleted First   [" + list.removeFirst() + "]   \t");
		list.print();
		System.out.print("Deleted index 0 [" + list.remove(0) + "]   \t");
		list.print();
		
		list.reverse();
		System.out.print("Reverse list ");
		list.print();
	}

}
