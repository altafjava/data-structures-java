package com.altafjava.bootcamp.day10;

import java.util.Arrays;

/*
Given an unsorted array of size n. Array elements are in the range of 1 to n.
One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Example 1: 
Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 2 is missing and 3 occurs twice 

Example 1:
Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

Companies: Amazon, Samsung, D-E-Shaw, Goldman Sachs, MAQ Software

Time Complexity: O(n)
Space Complexity: O(1)
*/
public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 6, 2, 1, 1 };
//		int[] nums = { 3, 1, 3 };
//		int[] nums = { 7, 3, 4, 5, 5, 6, 2 };
		int[] numbers = findRepeatingAndMissingNumbers(nums);
		System.out.println(Arrays.toString(numbers));
	}

	static public int[] findRepeatingAndMissingNumbers(int[] nums) {
		int repeatingNo = nums[0];
		int missingNo = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -nums[index];
			} else {
				repeatingNo = Math.abs(nums[i]);
			}

		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				missingNo = i + 1;
				break;
			}
		}
		return new int[] { repeatingNo, missingNo };
	}
}
