package net.guhya.algo.general;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * By using 2 heaps to maintain equal half of the array, we can easily get the median by peeking
 * @author  Guhya Wijaya
 *
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private boolean isEven = true;
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (isEven) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if (isEven) {
            return (minHeap.peek() + maxHeap.peek()) / (double) 2;
        } else {
            return maxHeap.peek();
        }
    }
    
    public void traverse() {
    }
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
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
