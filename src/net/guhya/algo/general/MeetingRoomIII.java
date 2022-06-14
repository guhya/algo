package net.guhya.algo.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class MeetingRoomIII {

	public static boolean isPossibleFailHelper(LinkedList<int[]> meetingList, int[] q) {
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
	
	public static boolean[] isPossibleFail(int[][] cal, int[][] q) {
		boolean[] result = new boolean[q.length];
		Arrays.sort(cal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? 1 : -1;
			}
		});
		
		LinkedList<int[]> meetingList = new LinkedList<>();
		for (int i=0; i<cal.length; i++) {
			meetingList.add(cal[i]);
		}		
		
		for (int i=0; i<q.length; i++) {
			result[i] = isPossibleFailHelper(meetingList, q[i]);
		}
		
		for (int i=0; i<meetingList.size(); i++) {
			System.out.println(Arrays.toString(meetingList.get(i)));
		}

		return result;
	}
	
	public static boolean[] isPossible(int[][] cal, int[][] q, int numberOfRoom) {
		boolean[] result = new boolean[q.length];
		Arrays.fill(result, true);
		
		int[] starts = generateSortedInterval(cal, 0);
		int[] ends = generateSortedInterval(cal, 1);
		System.out.println(Arrays.toString(starts));
		System.out.println(Arrays.toString(ends));
		
		Map<Integer, Integer> roomCountMap = generateRoomCountMap(starts, ends);
		System.out.println(roomCountMap);
		
		for (int i=0; i<q.length; i++) {
			for (int end : roomCountMap.keySet()) {
				if (q[i][0] < end && q[i][1] >= end && roomCountMap.get(end) >= numberOfRoom) {
					result[i] = false;
					break;
				}
			}
		}

		return result;
	}
	
	private static int[] generateSortedInterval(int[][] cal, int idx) {
		int[] arr = new int[cal.length];
		
		for (int i=0; i<cal.length; i++) {
			arr[i] = cal[i][idx];
		}
		
		Arrays.sort(arr);
		
		return arr;
	}
	
	static class Schedule {
		int time;
		String flag;
		int roomNumber;
		Schedule(int time, String flag, int roomNumber) {
			this.time = time;
			this.flag = flag;
			this.roomNumber = roomNumber;
		}
		public String toString() {
			return "[" + this.flag + this.time+ "," + this.roomNumber + "]";
		}
	}
	
	private static Map<Integer, Integer> generateRoomCountMap(int[] starts, int[] ends) {
		Map<Integer, Integer> roomCountMap = new LinkedHashMap<>();
		LinkedList<Schedule> timetable = new LinkedList<>();
		int i = 0, j = 0;
		int roomCount = 0, max = 0;
		while (i < starts.length) {
			if (starts[i] < ends[j]) {
				roomCount++;
				timetable.add(new Schedule(starts[i], "S", roomCount));
				i++;
				max = Math.max(max, roomCount);
			} else {
				roomCount--;
				timetable.add(new Schedule(ends[j], "E", roomCount));
				j++;
			}
		}
		
		while (j < ends.length) {
			roomCount--;
			timetable.add(new Schedule(ends[j], "E", roomCount));
			j++;
		}
		
		System.out.println(timetable);

		return roomCountMap;
	}
	
	public static boolean[] isPossibleCombine(int[][] cal, int[][] q, int numberOfRoom) {
		boolean[] result = new boolean[q.length];
		Arrays.fill(result, true);
		
		int[] starts = generateSortedInterval(cal, 0);
		int[] ends = generateSortedInterval(cal, 1);
		
		
		System.out.println(Arrays.toString(starts));
		System.out.println(Arrays.toString(ends));
		
		return result;
	}
	
	public static void main(String[] args) {
		/*
		int[][] cal1 = {{4,5},{8,10},{1,2}};
		int[][] q1 = {{2,3},{3,4}};
		System.out.println(Arrays.toString(isPossible(cal1, q1, 1)));
		System.out.println("+++++++++++");
		int[][] cal2 = {{1,2},{4,5},{8,10}};
		int[][] q2 = {{4,5},{5,6}};
		System.out.println(Arrays.toString(isPossible(cal2, q2, 1)));
		*/
		
		System.out.println("+++++++++++");
		int[][] cal3 = {{1, 3}, {4, 6}, {6, 8}, {9, 11}, {6, 9}, {1, 3}, {4, 10}};
		int[][] q3 = {{1, 9}, {2, 6}, {7, 9}, {3, 5}, {3, 9}, {2, 4}, {7, 10}, {5, 9}, {3, 10}, {9, 10}};
		System.out.println(Arrays.toString(isPossible(cal3, q3, 3)));
		
	}

}
