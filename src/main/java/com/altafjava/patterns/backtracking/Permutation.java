package com.altafjava.patterns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
46. Permutations
https://leetcode.com/problems/permutations/description/

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
*/
public class Permutation {
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> permute = permute(nums);
		System.out.println(permute);
	}

	static public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, ArrayList<Integer> permutation, int[] nums) {
		if (permutation.size() == nums.length)
			result.add(new ArrayList<>(permutation));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (permutation.contains(nums[i]))
					continue;
				permutation.add(nums[i]);
				backtrack(result, permutation, nums);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}
