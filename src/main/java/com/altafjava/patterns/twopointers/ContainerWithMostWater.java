package com.altafjava.patterns.twopointers;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store. Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
//		int[] heights = { 1, 1 };
		int maxArea = new ContainerWithMostWater().maxArea(heights);
		System.out.println(maxArea);
	}

	/**
	 * Time complexity: O(n). Single pass.</br>
	 * Space complexity: O(1). Constant space is used.</br>
	 * 
	 * @param heights
	 * @return
	 */
	public int maxArea(int[] heights) {
		int i = 0, j = heights.length - 1, maxArea = 0;
		while (i < j) {
			int width = j - i;
			int height = Math.min(heights[i], heights[j]);
			int area = height * width;
			if (area > maxArea)
				maxArea = area;
			if (heights[i] <= heights[j])
				i++;
			else if (heights[i] > heights[j])
				j--;
		}
		return maxArea;
	}

	/**
	 * Time complexity: O(n^2)</br>
	 * Space complexity: O(1). Constant extra space is used.</br>
	 * 
	 * @param heights
	 * @return
	 */
	public int maxArea_BruteForce(int[] heights) {
		int maxarea = 0;
		for (int i = 0; i < heights.length - 1; i++) {
			for (int j = i + 1; j < heights.length; j++) {
				int width = j - i;
				int height = Math.min(heights[i], heights[j]);
				int area = height * width;
				if (area > maxarea)
					maxarea = area;
			}
		}
		return maxarea;
	}

}
