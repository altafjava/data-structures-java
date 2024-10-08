package com.altafjava.patterns.twopointers;

/*
42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
    n == height.length
    1 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5
*/
public class TrappingRainWater {

	public static void main(String[] args) {
//		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 0, 3, 2, 5 };
		int trap = trap(height);
		System.out.println(trap);
	}

	static public int trap(int[] height) {
		int result = 0, left = 0, right = height.length - 1;
		int leftMax = height[0], rightMax = height[right];
		while (left < right) {
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]);
				result += leftMax - height[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, height[right]);
				result += rightMax - height[right];
			}
		}
		return result;
	}

}
