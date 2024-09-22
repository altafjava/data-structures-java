package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
39. Combination Sum
https://leetcode.com/problems/combination-sum/description/

Given an array of distinct integers candidates and a target integer target, return a list of all unique
combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different. The test cases are generated such that the number
of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Constraints:
    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
*/
public class CombinationSum {

	public static void main(String[] args) {
		int candidates[] = { 8, 7, 4, 3 }, target = 11;
//		int candidates[] = { 2, 3, 6, 7 }, target = 7;
//		int candidates[] = { 2, 3, 5 }, target = 8;
//		int candidates[] = { 2 }, target = 1;
		List<List<Integer>> combinationSum = combinationSum(candidates, target);
		System.out.println(combinationSum);
	}

	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(candidates, target, 0, result, new ArrayList<>());
		return result;
	}

	static private void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, ArrayList<Integer> current) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
		} else if (target > 0) {
			for (int i = index; i < candidates.length; i++) {
				current.add(candidates[i]);
				backtrack(candidates, target - candidates[i], i, result, current);
				current.remove(current.size() - 1);
			}
		}
	}
}