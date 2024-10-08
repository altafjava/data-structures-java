package com.altafjava.bootcamp.day07;

/*
287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/description/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
    1 <= n <= 10^5
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
    How can we prove that at least one duplicate number must exist in nums?
    Can you solve the problem in linear runtime complexity?
 */
public class FindDuplicate {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 4, 2, 2 };
//		int nums[] = { 3, 1, 3, 4, 2 };
//		int nums[] = { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
		int mark = findDuplicate(nums);
		System.out.println(mark);
	}

	static public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

//	static public int findDuplicate(int[] nums) {
//		for (int num : nums) {
//			int index = Math.abs(num);
//			if (nums[index] < 0)
//				return index;
//			nums[index] = -nums[index];
//		}
//		return -1;
//	}
}
