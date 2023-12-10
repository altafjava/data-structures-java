package com.altafjava.bootcamp.day26;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
    
Time Complexity: O(N * 2^N)
Space Complexity: O(N * 2^N)
*/
public class SubsetsRecursive {

	public static void main(String[] args) {
		SubsetsRecursive s = new SubsetsRecursive();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = s.subsets(nums);
		System.out.println(result);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<>(), result);
		return result;
	}

	private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for (int i = index; i < nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, result);
			current.remove(current.size() - 1);
		}
	}

}
