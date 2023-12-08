package com.altafjava.bootcamp.day23;

import java.util.Arrays;

/*
42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
    n == height.length
    1 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5
*/
public class TrappingRainWaterTwoPointer {

	public static void main(String[] args) {
//		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 0, 3, 2, 5 };
		int trap = trap(height);
		System.out.println(trap);
	}

	public static int trap(int[] height) {
		int sum = 0;
		int[] lh = leftMaxHeight(height);
		int[] rh = rightMaxHeight(height);
		System.out.println(Arrays.toString(lh));
		System.out.println(Arrays.toString(rh));
		for (int i = 0; i < height.length; i++) {
			int min = Math.min(lh[i], rh[i]);
			int trap = min - height[i];
			if (trap > 0)
				sum += trap;
		}
		return sum;
	}

	private static int[] leftMaxHeight(int[] height) {
		int lh[] = new int[height.length], max = 0;
		lh[0] = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i - 1] > max)
				max = height[i - 1];
			lh[i] = max;
		}
		return lh;
	}

	private static int[] rightMaxHeight(int[] height) {
		int rh[] = new int[height.length], max = 0;
		rh[height.length - 1] = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i + 1] > max)
				max = height[i + 1];
			rh[i] = max;
		}
		return rh;
	}

}
