package net.guhya.algo.general;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MissingNumber {

    private static int missingNumber(int[] arr) {
        int[] bucket = new int[arr.length+1];
        for (int i=0; i<arr.length; i++) {
            bucket[arr[i]] = arr[i];
        }
        
        for (int i=1; i<bucket.length; i++) {
            if (bucket[i] == 0) return i;
        }
        
        return 0;
    }

    private static int missingNumberSum(int[] arr) {
        int sum = 0;
        for (int i=0; i<=arr.length; i++) {
            sum += i;
        }
        
        for (int i=0; i<arr.length; i++) {
            sum -= arr[i];
        }
        
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,0,1};
        System.out.println(missingNumber(arr1));
        System.out.println(missingNumberSum(arr1));
    }

}
