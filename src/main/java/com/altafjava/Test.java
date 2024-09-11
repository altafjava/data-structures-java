package com.altafjava;

import java.util.Arrays;

/**
Q1: Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

23*60=1380+59=1439
00:00 24*60=1440

1440,1439,1440
*/
public class Test {

	public static void main(String[] args) {
//		String[] timePoints = { "23:59", "00:00" };
//		String[] timePoints = {"00:00","23:59","00:00"};
		String[] timePoints = {"00:00", "12:00", "23:59"};
		int minMinues = minMinues(timePoints);
		System.out.println(minMinues);
	}

	public static int minMinues(String[] timePoints) {
		int[] times = new int[timePoints.length];
		for (int i = 0; i < timePoints.length; i++) {
			int minutes = convertStringTimeToMinutes(timePoints[i]);
			times[i] = minutes;
		}
		Arrays.sort(times);
		int minTime = Integer.MAX_VALUE;
		for (int i = 0; i < times.length - 1; i++) {
			int diff = Math.abs(times[i] - times[i + 1]);
			minTime = Math.min(minTime, diff);
		}
		return minTime;
	}

	static int convertStringTimeToMinutes(String time) {
		String[] splits = time.split(":");
		String hour = refineTime(splits[0]);
		int hourInt = Integer.parseInt(hour);
		String minute = splits[1];
		int minuteInt = Integer.parseInt(minute);
		int totalMinutes = (hourInt * 60) + minuteInt;
		return totalMinutes;
	}

	static String refineTime(String time) {
		if (time.equals("00"))
			return "24";
		return time;
	}

}
