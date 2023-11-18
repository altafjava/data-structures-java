package com.altafjava.bootcamp.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
such that:
    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109

Time Complexity: O(n^3)
Space COmplexity: O(1)
*/
public class FourSum {

	public static void main(String[] args) {
//		int nums[] = { 1, 0, -1, 0, -2, 2 }, target = 0;
//		int nums[] = { 2, 2, 2, 2, 2 }, target = 8;
		int nums[] = { 1000000000, 1000000000, 1000000000, 1000000000 }, target = -294967296;
		List<List<Integer>> arr = fourSum(nums, target);
		System.out.println(arr);
	}

	static public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
						result.add(list);
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;
					}
				}
			}
		}
		return result;
	}

}
