package com.altafjava.neetcode.intervals;

import java.util.Arrays;

/*
919 · Meeting Rooms II
https://www.lintcode.com/problem/919/

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Note: (0,8),(8,10) is not conflict at 8

Example1
Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)

Example2
Input: intervals = [(2,7)]
Output: 1
Explanation: Only need one meeting room
*/
public class MeetingRooms2 {

	public static void main(String[] args) {
//		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[][] intervals = { { 2, 7 } };
		int meetingRooms = minMeetingRooms(intervals);
		System.out.println(meetingRooms);
	}

	static public int minMeetingRooms(int[][] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i][0];
			ends[i] = intervals[i][1];
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int s = 0, e = 0, count = 0, result = 0;
		while (s < intervals.length) {
			if (starts[s] < ends[e]) {
				count++;
				s++;
			} else {
				count--;
				e++;
			}
			result = Math.max(result, count);
		}
		return result;
	}

}
