package net.guhya.algo.sorting;

import java.util.Arrays;

public class CountingSort {

    /**
     * Put in the bucket, and get it again, also handle minus value.
     * Only good if range between minimum and maximum value is small.
     * @param arr
     */
    public static void countingSort(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int[] bucket = new int[26];
        for (int i=0; i<arr.length; i++) {
            bucket[arr[i]-min]++;
        }
        
        int idx = 0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                arr[idx] = i + min;
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {7,6,8,3,1,5,0};
        System.out.println(Arrays.toString(arr1));
        countingSort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("++++++++++");
        
        int[] arr2 = {7,6,8,3,5,5,0};
        System.out.println(Arrays.toString(arr2));
        countingSort(arr2);
        System.out.println(Arrays.toString(arr2));
        
        System.out.println("++++++++++");
        int[] arr3 = {7,-6,8,3,5,-5,0};
        System.out.println(Arrays.toString(arr3));
        countingSort(arr3);
        System.out.println(Arrays.toString(arr3));
        
        System.out.println("++++++++++");
        int[] arr4 = {-5,-10,0,-3,8,5,-1,10};
        System.out.println(Arrays.toString(arr4));
        countingSort(arr4);
        System.out.println(Arrays.toString(arr4));
        
        System.out.println("++++++++++");
        int arr5[]  = {'y','u','i','a','s','h','f','a'};
        System.out.println(Arrays.toString(arr5));
        countingSort(arr5);
        System.out.println(Arrays.toString(arr5));
        for (int i=0; i<arr5.length; i++) System.out.print((char) arr5[i]);
    }   

}
