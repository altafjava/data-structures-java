package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.altafjava.aop.Omit;
import com.altafjava.aop.Print;

/*
40. Combination Sum II
https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique 
combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
*/
public class CombinationSum2 {

	public static void main(String[] args) {
		int candidates[] = { 10, 1, 2, 7, 6, 1, 5 }, target = 8;
		List<List<Integer>> combinationSum = combinationSum(candidates, target);
		System.out.println(combinationSum);
	}

	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, 0, result, current);
		return result;
	}

	@Print
	static private void backtrack(@Omit int[] candidates, int target, int index, @Omit List<List<Integer>> result, List<Integer> current) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
			if (i > index && candidates[i] == candidates[i - 1])
				continue;
			int candidate = candidates[i];
			current.add(candidate);
			backtrack(candidates, target - candidate, i + 1, result, current);
			current.remove(current.size() - 1);
		}
	}

}