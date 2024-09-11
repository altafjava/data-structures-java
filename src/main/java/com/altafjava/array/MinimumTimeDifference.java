package com.altafjava.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
539. Minimum Time Difference
https://leetcode.com/problems/minimum-time-difference/description/

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between 
any two time-points in the list.

Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

Constraints:

    2 <= timePoints.length <= 2 * 104
    timePoints[i] is in the format "HH:MM".

*/
public class MinimumTimeDifference {

	public static void main(String[] args) {
//		String[] timePoints = { "23:59","00:00" };//1
//		String[] timePoints = { "23:59","00:01" };//2
//		String[] timePoints = { "00:00", "23:59", "00:00" };
//		String[] timePoints = {"01:01","02:01"};
		String[] timePoints = { "12:12", "00:13" };//719
//		List<String> list = List.of(timePoints);
		List<String> list = Arrays.asList(timePoints);
		int minDifference = findMinDifference(list);
		System.out.println(minDifference);
	}

	static public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints);
		int minDiff = Integer.MAX_VALUE;
		int firstTime = timeInMinutes(timePoints.get(0));
		int prevTime = firstTime;
		for (int i = 1; i < timePoints.size(); i++) {
			int currentTime = timeInMinutes(timePoints.get(i));
			minDiff = Math.min(minDiff, currentTime - prevTime);
			prevTime = currentTime;
		}
		// Handle the circular wrap-around difference between the last and first time points
		// Adding 1440 (24 hours) to the first time point to simulate the next day's 00:00
		// Then, subtract the last time point of the current day from this "next day" first time point.
		// This ensures we correctly compute the smallest circular time difference.
		int lastTime = timeInMinutes(timePoints.get(timePoints.size() - 1));
		minDiff = Math.min(minDiff, (firstTime + 1440) - lastTime);
		return minDiff;
	}

	static private int timeInMinutes(String firstTime) {
		String[] splits = firstTime.split(":");
		int hour = Integer.parseInt(splits[0]);
		int minute = Integer.parseInt(splits[1]);
		return hour * 60 + minute;
	}
}
