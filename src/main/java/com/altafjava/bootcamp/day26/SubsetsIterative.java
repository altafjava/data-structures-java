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
public class SubsetsIterative {

	public static void main(String[] args) {
		SubsetsIterative s = new SubsetsIterative();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = s.subsets(nums);
		System.out.println(result);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int num : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(num);
				result.add(subset);
			}
		}
		return result;
	}

}
