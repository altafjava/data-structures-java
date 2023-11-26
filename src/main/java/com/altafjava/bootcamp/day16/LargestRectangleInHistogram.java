package com.altafjava.bootcamp.day16;

import java.util.ArrayDeque;

/*
84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/description/

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
    1 <= heights.length <= 10^5
    0 <= heights[i] <= 10^4
*/
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
//		int[] heights = { 2, 1, 5, 6, 2, 3 };
//		int[] heights = { 2, 4 };
//		int[] heights = {7526,2268,7746,6830,6480,3846,9924,9681,2569,884,8244,1815,9000,6580,3955,3176,950,6427,8420,8194,359,2097,3085,1330,132,6469};
//		int[] heights = {7526,2268,7746,6830,6480,3846,9924,9681,2569,884,8244};
//		int[] heights = {75,22,77,68,64};
		int[] heights = { 6, 2, 7, 5, 4 };
		int largestRectangleArea = largestRectangleArea2(heights);
		System.out.println(largestRectangleArea);
	}

	public static int largestRectangleArea2(int[] heights) {
		int len = heights.length;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			while (!stack.isEmpty() && (i == len || heights[i] < heights[stack.peek()])) {
				int prevIndex = stack.pop();
				int height = heights[prevIndex];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(i);
		}
		return maxArea;
	}

//	public static int largestRectangleArea(int[] heights) {
//		int maxArea = 0;
//		for (int i = 0; i < heights.length; i++) {
//			int minHeight = heights[i];
//			for (int j = i; j < heights.length; j++) {
//				minHeight = Math.min(minHeight, heights[j]);
//				int width = j - i + 1;
//				maxArea = Math.max(maxArea, minHeight * width);
//			}
//		}
//		return maxArea;
//	}

}
