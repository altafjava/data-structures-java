package com.altafjava.bootcamp.day08;

import java.util.Arrays;

/*
31. Next Permutation
https://leetcode.com/problems/next-permutation/description/

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: 
 [1,2,3], [1,3,2],
 [2, 1, 3], [2, 3, 1],
 [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 100

Time Complexity: O(n)
Space Complexity: O(1)
*/
public class NextPermutation {

	public static void main(String[] args) {
//		int[] nums1 = { 1, 2, 3 };
//		nextPermutation(nums1);
//		System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 2]
//
//		int[] nums2 = { 3, 2, 1 };
//		nextPermutation(nums2);
//		System.out.println(Arrays.toString(nums2)); // Output: [1, 2, 3]
//
//		int[] nums3 = { 1, 1, 5 };
//		nextPermutation(nums3);
//		System.out.println(Arrays.toString(nums3)); // Output: [1, 5, 1]

//		int[] nums3 = { 0, 1, 2, 9, 8, 4, 3 };
//		nextPermutation(nums3);
//		System.out.println(Arrays.toString(nums3)); // Output: [0, 1, 3, 2, 4, 8, 9]

		int[] nums3 = { 9, 8, 4, 3 };
		nextPermutation(nums3);
		System.out.println(Arrays.toString(nums3)); // Output: [3, 4, 8, 9]
	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		// Find the first element from the right that is smaller than its next element
		int i = n - 1;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		// If such an element is found, find the smallest element to the right of i that is larger than nums[i]
		if (i >= 0) {
			int j = n - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		// Reverse the sub-array to the right of i
		reverse(nums, i + 1, n - 1);
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
}
