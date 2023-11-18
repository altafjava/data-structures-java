package com.altafjava.bootcamp.day09;

import java.util.Arrays;

/*
912. Sort an Array
https://leetcode.com/problems/sort-an-array/description/

Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and
with the smallest space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.

Constraints:
    1 <= nums.length <= 5 * 104
    -5 * 104 <= nums[i] <= 5 * 104
Time Complexity: O(n log n)
Space Complexity: O(n)
*/
public class MergeSort {

	public static void main(String[] args) {
//		int[] nums = { 5, 2, 3, 1 };
		int[] nums = { 5, 1, 1, 2, 0, 0 };
		System.out.println("Before: " + Arrays.toString(nums));
		int[] sortedArray = sortArray(nums);
		System.out.println("After: " + Arrays.toString(sortedArray));
	}

	static public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low == high)
			return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int left = low, right = mid + 1;
		int temp[] = new int[high - low + 1], k = 0;
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp[k++] = arr[left];
				left++;
			} else {
				temp[k++] = arr[right];
				right++;
			}
		}
		while (left <= mid) {
			temp[k++] = arr[left++];
		}
		while (right <= high) {
			temp[k++] = arr[right++];
		}
		for (int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}
	}

}
