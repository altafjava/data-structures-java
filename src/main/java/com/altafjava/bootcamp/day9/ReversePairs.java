package com.altafjava.bootcamp.day9;

/*
493. Reverse Pairs
https://leetcode.com/problems/reverse-pairs/description/

Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i, j) where:
    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].

Example 1:
Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

Example 2:
Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

Constraints:
    1 <= nums.length <= 5 * 10^4
    -2^31 <= nums[i] <= 2^31 - 1
*/
public class ReversePairs {

	public static void main(String[] args) {
//		int[] nums = { 1, 3, 2, 3, 1 };
//		int[] nums = { 2, 4, 3, 5, 1 };
//		int[] nums = { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 };
//		int[] nums = { 2, 2, -2, -2, -2, 2 };
		int[] nums = { 2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647 };
//		int[] nums = { -5, -5, -5 };
		int reversePairs = reversePairs(nums);
		System.out.println(reversePairs);
	}

	static public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	private static int mergeSort(int[] nums, int low, int high) {
		int count = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			count += mergeSort(nums, low, mid);
			count += mergeSort(nums, mid + 1, high);
			count += countPairs(nums, low, mid, high);
			merge(nums, low, mid, high);
		}
		return count;
	}

	private static int countPairs(int[] nums, int low, int mid, int high) {
		int left = low, right = mid + 1, count = 0;
		while (left <= mid && right <= high) {
			if (nums[left] > nums[right] * 2L) {
				count += mid - left + 1;
				right++;
			} else {
				left++;
			}
		}
		return count;
	}

	private static void merge(int[] nums, int low, int mid, int high) {
		int left = low, right = mid + 1;
		int temp[] = new int[high - low + 1], k = 0;
		while (left <= mid && right <= high) {
			if (nums[left] <= nums[right]) {
				temp[k++] = nums[left++];
			} else {
				temp[k++] = nums[right++];
			}
		}
		while (left <= mid) {
			temp[k++] = nums[left++];
		}
		while (right <= high) {
			temp[k++] = nums[right++];
		}
		for (int i = low; i <= high; i++)
			nums[i] = temp[i - low];
	}
}
