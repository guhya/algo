package net.guhya.algo.queue;

public class TheQueue {
	
	private static final int MAX = 5;
	private int front = 0;
	private int rear = -1;
	private int size = 0;
	private int[] arr = new int[MAX];
	
	public void enqueu(int value) {
		
		if (size == MAX) throw new IllegalArgumentException(); 
		
		rear = (rear + 1) == MAX ? 0 : rear + 1;
		arr[rear] = value;
		size++;
	}
	
	public int dequeu() {
		
		if (size == 0) throw new IllegalArgumentException(); 
		
		int v = arr[front];
		front = (front + 1) == MAX ? 0 : front + 1;
		size--;
		
		return v;
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Size : " + size);
		sb.append(" Front : " + front);
		sb.append(" Rear : " + rear);
		sb.append(" [");
		for (int i=0; i<size; i++) {
			sb.append(i == (size-1) ? arr[(front + i) % MAX] : arr[(front + i) % MAX] + ", ");
		}
		sb.append("]");
		
		return sb.toString();
	}
	

	public static void main(String[] args) {
		TheQueue tq = new TheQueue();
		tq.enqueu(1);
		tq.enqueu(2);
		tq.enqueu(3);
		tq.enqueu(4);
		tq.enqueu(5);
		System.out.println(tq);
		
		tq.dequeu();
		tq.dequeu();
		
		System.out.println(tq);
		tq.dequeu();
		tq.dequeu();
		tq.enqueu(4);
		tq.dequeu();
		System.out.println(tq);
	}

}
