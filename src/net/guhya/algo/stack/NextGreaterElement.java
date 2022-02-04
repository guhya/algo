package net.guhya.algo.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	
	static class TheStack {
		private int top = -1;
		private int max;
		private int[] arr;
		
		public TheStack(int size) {
			max = size;
			arr = new int[max];
		}
		
		public void push(int value) {
			if (top == max -1) throw new IllegalArgumentException();

			top++;
			arr[top] = value;
		}
		
		public int pop() {
			if (top == -1) throw new IllegalArgumentException();

			int value = arr[top];
			top--;
			return value;
		}
		
		public int peek() {
			if (top == -1) throw new IllegalArgumentException();

			return arr[top];
		}
		
		public boolean isEmpty() {
			return top == -1;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i=0; i<=top; i++) {
				sb.append(i == top ? arr[i] : arr[i] + ", ");
			}
			sb.append("]");
			
			return sb.toString();
		}
		
		
	}
	
	public static int[] printNextGreater(int[] arr) {
		int len = arr.length;
		if (len == 0) throw new IllegalArgumentException();
		
		int[] nge = new int[len];
		TheStack stack = new TheStack(len);
		for (int i=len-1; i>=0; i--) {
			int el = arr[i];
			while (!stack.isEmpty() && stack.peek() <= el) {
				stack.pop();
			}
			
			nge[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(el);
		}
		
		return nge;
	}

	public static void printNextGreaterFrequency(int[] arr) {
		int len = arr.length;
		if (len == 0) return;
		
		Map<Integer, Integer> fMap = new HashMap<>();
		for (int i=0; i<len; i++) {
			int v = fMap.get(arr[i]) == null ? 0 : fMap.get(arr[i]);
			fMap.put(arr[i], ++v);
		}
		
		int[] arrFreq = new int[len];
		for (int i=0; i<len; i++) {
			arrFreq[i] = fMap.get(arr[i]);
		}
		System.out.println(Arrays.toString(arrFreq));
		
		int[] nge = new int[len];
		TheStack stack = new TheStack(len);
		for (int i=len-1; i>=0; i--) {
			int el = arrFreq[i];
			while (!stack.isEmpty() && arrFreq[stack.peek()] <= el) {
				stack.pop();
			}
			
			nge[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		
		for (int i=0; i<len; i++) {
			nge[i] = nge[i] == -1 ? -1 : arr[nge[i]];
		}
		
		System.out.println(Arrays.toString(nge));
	}

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] result = new int[len];
        int[] temp = new int[nums2.length];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
        	indexMap.put(nums2[i], i);
        }
        
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<nums2.length; i++) {
        	if (s.isEmpty()) {
        		s.add(nums2[i]);
        	} else {
        		while (!s.isEmpty()) {
	        		if (nums2[i] > s.peek()) {
	        			System.out.println(s.peek() + " -> " + nums2[i]);
	        			temp[indexMap.get(s.pop())] = nums2[i];
	        		} else {
	        			break;
	        		}
        		}
    			s.add(nums2[i]);
        	}
        }
        while (!s.isEmpty()) {
        	temp[indexMap.get(s.pop())] = -1;
        }
        
        for (int i=0; i<nums1.length; i++) {
        	result[i] = temp[indexMap.get(nums1[i])];
        }
        
        return result;
    }	
	
	public static void main(String[] args) {
		TheStack ts = new TheStack(4);
		ts.push(4);
		ts.push(5);
		ts.push(2);
		ts.push(25);
		ts.pop();
		ts.push(25);
		System.out.println(ts.peek());
		System.out.println(ts);
		
		int[] arr = {4, 5, 2, 25};
		System.out.println(Arrays.toString(printNextGreater(arr)));
		
		int[] arrFrequency = {1, 1, 2, 3, 4, 2, 1};
		printNextGreaterFrequency(arrFrequency);
		
		int[] arrFrequency2 = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
		printNextGreaterFrequency(arrFrequency2);
		
		int[] nums1 = {4, 1, 2};
		int[] nums2 = {1, 3, 4, 2};
		
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}

}
