package net.guhya.algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomII {

	
	public static void helper(int[][] meetings, int idx, List<List<int[]>> roomList) {
		if (idx == meetings.length) return;
		
		int[] meeting = meetings[idx];
		boolean isNotFit = true;
		for (List<int[]> room : roomList) {
			if (room.size() > 0) {
				int[] lastMeeting = room.get(room.size()-1);
				if (lastMeeting[1] <= meeting[0]) {
					room.add(meeting);
					isNotFit = false;
					break;
				}
			}
		}
		
		if (isNotFit) {
			List<int[]> newRoom = new ArrayList<int[]>();
			newRoom.add(meeting);
			roomList.add(newRoom);
		}
		
		helper(meetings, idx+1, roomList);
	}
	
	public static int howManyRooms(int[][] cal) {
		Arrays.sort(cal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? 1 : -1;
			}
		});

		List<List<int[]>> roomList = new ArrayList<>();
		for (int i=0; i<cal.length; i++) {
			int[] meeting = cal[i];
			boolean isNotFit = true;
			for (List<int[]> room : roomList) {
				if (room.size() > 0) {
					int[] lastMeeting = room.get(room.size()-1);
					if (lastMeeting[1] <= meeting[0]) {
						room.add(meeting);
						isNotFit = false;
						break;
					}
				}
			}
			
			if (isNotFit) {
				List<int[]> newRoom = new ArrayList<int[]>();
				newRoom.add(meeting);
				roomList.add(newRoom);
			}
		}
		
		for (List<int[]> room : roomList) {
			for (int[] meeting : room)
				System.out.print(Arrays.toString(meeting));
			System.out.println("");
		}
		
		return roomList.size();
	}
	
	
	public static int howManyRoomsSort(int[][] cal) {
		int[] starts = new int[cal.length];
		int[] ends = new int[cal.length];
		
		for (int i=0; i<cal.length; i++) {
			starts[i] = cal[i][0];
			ends[i] = cal[i][1];
		}
		
		Arrays.sort(starts);
		Arrays.sort(ends);
		
		Map<Integer, Integer> roomCountMap = new LinkedHashMap<>();
		int i = 0, j = 0;
		int roomCount = 0, max = 0;
		while (i < starts.length) {
			if (starts[i] < ends[j]) {
				System.out.println(starts[i] + " < " + ends[j]);
				i++;
				roomCount++;
				roomCountMap.put(ends[j], roomCount);
			} else {
				j++;
				roomCount = 0;
			}
			
			max = Math.max(roomCount, max);
		}
		
		System.out.println(roomCountMap);
		
		return max;
	}
	
	public static void main(String[] args) {
		int[][] cal1 = {{1,10},{2,8},{11,15},{15,16},{3,4}};
		System.out.println(howManyRoomsSort(cal1));
		System.out.println("+++++++++++");
		int[][] cal2 = {{1, 3}, {4, 6}, {6, 8}, {9, 11}, {6, 9}, {1, 3}, {4, 10}};
		System.out.println(howManyRooms(cal2));
		System.out.println("+++++++++++");
	}

}
