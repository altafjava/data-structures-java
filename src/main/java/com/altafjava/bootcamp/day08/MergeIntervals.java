package com.altafjava.bootcamp.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
56. Merge Intervals
https://leetcode.com/problems/merge-intervals/description/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104

Time Complexity: O(n logN)
Space Complexity: O(n)
*/
public class MergeIntervals {

	public static void main(String[] args) {
//		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//		int[][] intervals = { { 1, 4 }, { 4, 5 } };
//		int[][] intervals = {{1, 3}};
		int[][] intervals = { { 1, 3 }, { 5, 7 }, { 9, 11 } };
		int[][] result = merge(intervals);
		System.out.println(Arrays.deepToString(result));
	}

	static public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int[] currentInterval = intervals[0];
		List<int[]> mergedIntervals = new ArrayList<>();
		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (currentInterval[1] >= interval[0]) {
				// Merge overlapping intervals
				currentInterval[1] = Math.max(currentInterval[1], interval[1]);
			} else {
				// No overlap, add the current interval to the result
				mergedIntervals.add(currentInterval);
				currentInterval = interval;
			}
		}
		// Add the last interval
		mergedIntervals.add(currentInterval);
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}

}
