package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
*/
public class Subsets2 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
//		int[] nums = { 4, 4, 4, 1, 4 };
		List<List<Integer>> result = subsetsWithDup(nums);
		System.out.println(result);
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(nums, 0, result, current);
		return result;
	}

	static private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {
		result.add(new ArrayList<>(current));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			current.add(nums[i]);
			backtrack(nums, i + 1, result, current);
			current.remove(current.size() - 1);
		}
	}
}