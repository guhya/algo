package net.guhya.algo.general;

public class MedianFinderList {
    
    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node root;
    private int size;
    
    public MedianFinderList() {
    }
    
    public void addNum(int num) {
        this.size++;
        if (this.root == null) {
            this.root = new Node(num);
            return;
        }
        
        Node current = this.root;
        Node prev = null;
        while (current != null) {
            if (current.val > num) {
                Node tmp = current;
                if (prev == null) {
                    this.root = new Node(num);
                    this.root.next = tmp;
                } else {
                    prev.next = new Node(num);
                    prev.next.next = tmp;
                }
                return;
            }
            
            if (current.next == null) {
                current.next = new Node(num);
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
    public double findMedian() {
        if (this.size == 1) return this.root.val;
        
        Node slow = this.root;
        Node fast = this.root.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (this.size % 2 == 0) {
            return (double) (slow.val + slow.next.val) / (double) 2;
        } else {
            return slow.val;
        }
    }
    
    public void traverse() {
        Node current = this.root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        MedianFinderList mf = new MedianFinderList();
        mf.addNum(1);
        mf.addNum(2);
        double median = mf.findMedian();
        System.out.println(median);
        mf.addNum(3);
        mf.traverse();
        median = mf.findMedian();
        System.out.println(median);
    }

}
