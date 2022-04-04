package net.guhya.algo.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static int minDiff(List<Integer> arr) {
        System.out.println(arr);
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2) return 0;
                return o1 > o2 ? 1 : -1;
            }
        });
        
        int l = arr.size();
        int diff = 0;
        for(int i=1; i<=l-1; i++) {
        	diff += Math.abs(arr.get(i) - arr.get(i-1));
        }
        System.out.println(diff);
        System.out.println(arr);
        
        return 0;

    }


    public static void main(String[] args) {
    	List<Integer> list = new ArrayList<>();
    	list.add(8);
    	list.add(3);
    	list.add(1);
    	list.add(9);
    	System.out.println(minDiff(list));
    }
}
