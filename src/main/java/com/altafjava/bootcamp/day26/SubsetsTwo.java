package com.altafjava.bootcamp.day26;

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
public class SubsetsTwo {

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 2 };
		int[] nums = { 4, 4, 4, 1, 4 };
		List<List<Integer>> result = subsetsWithDup(nums);
		System.out.println(result);
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		int startIndex = 0, endIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			startIndex = i > 0 && nums[i] == nums[i - 1] ? endIndex : 0;
			endIndex = result.size();
			for (int j = startIndex; j < endIndex; j++) {
				List<Integer> current = new ArrayList<>(result.get(j));
				current.add(nums[i]);
				result.add(current);
			}
		}
		return result;
	}

}
