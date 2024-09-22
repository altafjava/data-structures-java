package com.altafjava.neetcode.intervals;

import java.util.Arrays;

/*
920 · Meeting Rooms
https://www.lintcode.com/problem/920

Given an array of meeting time intervals consisting of start and end times [(s1,e1),(s2,e2),...] (si < ei),
determine if a person could attend all meetings.
    0≤intervals.length≤1040≤intervals.length≤104
    intervals[i].length==2intervals[i].length==2
    0≤starti<endi≤1060≤starti​<endi​≤106
    [(0,8), (8,10)] is not conflict at 8

Example 1:
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false

Explanation: 
(0,30), (5,10) and (0,30),(15,20) will conflict

Example 2:
Input: intervals = [(5,8),(9,15)]
Output: true
Explanation: 
Two times will not conflict 
*/
public class MeetingRooms {

	public static void main(String[] args) {
//		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[][] intervals = { { 5, 8 }, { 9, 15 } };
		boolean bool = canAttendMeetings(intervals);
		System.out.println(bool);
	}

	static public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
		for (int i = 0; i < intervals.length - 1; i++) {
			int end = intervals[i][1];
			int nextStart = intervals[i + 1][0];
			if (end > nextStart)
				return false;
		}
		return true;
	}

}
