package com.altafjava.neetcode.intervals;

import java.util.Arrays;

/*
435. Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/description/

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of 
intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Constraints:
    1 <= intervals.length <= 105
    intervals[i].length == 2
    -5 * 104 <= starti < endi <= 5 * 104
*/
public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
//		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
//		int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
//		int[][] intervals = { { 1, 2 }, { 2, 3 } };
		int result = eraseOverlapIntervals(intervals);
		System.out.println(result);
	}

	static public int eraseOverlapIntervals(int[][] intervals) {
		int count = 0;
		Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
		int[] prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] current = intervals[i];
			if (current[0] < prev[1]) {
				count++;
				prev[1] = Math.min(prev[1], current[1]);
			} else {
				prev = current;
			}
		}
		return count;
	}
}
