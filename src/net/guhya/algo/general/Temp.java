package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

	public static void main(String[] args) {
		String[] arr1 = {"A", "B", "C"};
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = new ArrayList<>(Arrays.asList(arr1));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), arr1[2]));
		System.out.println(list1.equals(list2));
		System.out.println(list2.equals(list3));

	}

}
