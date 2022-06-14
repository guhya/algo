package net.guhya.algo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MeetingRoomI {

	public static boolean isPossibleHelper(LinkedList<int[]> meetingList, int[] q) {
		boolean added = false;
		for (int i=0; i<meetingList.size(); i++) {
			if (!added && q[0] < meetingList.get(i)[1]) {
				if (q[1] <= meetingList.get(i)[0]) {
					meetingList.add(i, q);
					added = true;
				} else {
					return false;
				}
			}
		}
		
		if (!added) {
			meetingList.add(q);
		}
		
		return true;
	}
	public static boolean isPossible(int[][] cal) {
		Arrays.sort(cal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? 1 : -1;
			}
		});

		LinkedList<int[]> meetingList = new LinkedList<>();
		for (int i=0; i<cal.length; i++) {
			isPossibleHelper(meetingList, cal[i]);
		}		
		
		for (int i=0; i<meetingList.size(); i++) {
			System.out.println(Arrays.toString(meetingList.get(i)));
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] cal1 = {{0,30},{5,10},{15,20}};
		System.out.println(isPossible(cal1));
	}

}
