package com.altafjava.bootcamp.day07;

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution using the
divide and conquer approach, which is more subtle.
*/
public class MaxSubarraySum {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int sum = maxSubArray(nums);
		System.out.println(sum);
	}

	static public int maxSubArray(int[] nums) {
		int currentSum = nums[0];
		int maxSum = currentSum;
		for (int i = 1; i < nums.length; i++) {
			if (currentSum >= 0) {
				currentSum += nums[i];
			} else {
				currentSum = nums[i];
			}
			if (currentSum > maxSum)
				maxSum = currentSum;
		}
		return maxSum;
	}

	static public int maxSubArray2(int[] nums) {
		int maxSum = nums[0];
		int currentSum = maxSum;
		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(currentSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

}
