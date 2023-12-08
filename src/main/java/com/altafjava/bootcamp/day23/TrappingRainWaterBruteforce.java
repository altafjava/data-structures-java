package com.altafjava.bootcamp.day23;

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
public class TrappingRainWaterBruteforce {

	public static void main(String[] args) {
//		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 0, 3, 2, 5 };
		int trap = trap(height);
		System.out.println(trap);
	}

	public static int trap(int[] height) {
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			int lh = leftMaxHeight(i, height);
			int rh = rightMaxHeight(i, height);
			int min = Math.min(lh, rh);
			int trap = min - height[i];
			if (trap > 0)
				sum += trap;
		}
		return sum;
	}

	private static int leftMaxHeight(int ch, int[] height) {
		int max = 0;
		for (int i = ch - 1; i >= 0; i--) {
			if (height[i] > max)
				max = height[i];
		}
		return max;
	}

	private static int rightMaxHeight(int ch, int[] height) {
		int max = 0;
		for (int i = ch + 1; i < height.length; i++) {
			if (height[i] > max)
				max = height[i];
		}
		return max;
	}

}
