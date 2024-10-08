package com.altafjava.bootcamp.day07;

import java.util.Arrays;

/*
75. Sort Colors
https://leetcode.com/problems/sort-colors/description/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that
objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Time Complexity: O(n)
Space Complexity: O(1) 
*/
public class SortColors {

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
//		int[] nums = {2,0,1};
		System.out.println("Before: " + Arrays.toString(nums));
		sortColors(nums);
		System.out.println("After: " + Arrays.toString(nums));
	}

	static public void sortColors(int[] nums) {
		int i = 0, start = 0, end = nums.length - 1;
		while (i <= end && start < end) {
			if (nums[i] == 0) {
				nums[i] = nums[start];
				nums[start] = 0;
				i++;
				start++;
			} else if (nums[i] == 2) {
				nums[i] = nums[end];
				nums[end] = 2;
				end--;
			} else {
				i++;
			}
		}
	}

}
