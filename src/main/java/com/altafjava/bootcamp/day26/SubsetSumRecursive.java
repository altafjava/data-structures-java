package com.altafjava.bootcamp.day26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given a list arr of N integers, return sums of all subsets in it.

Example 1:
Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.

Example 2:
Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 15
0 <= arr[i] <= 10^4
*/
public class SubsetSumRecursive {

	public static void main(String[] args) {
		SubsetSumRecursive s = new SubsetSumRecursive();
//		int[] nums = { 1, 2, 3 }; // [0, 1, 2, 3, 3, 4, 5, 6]
		int[] nums = { 5, 2, 1 }; // [0, 1, 2, 3, 5, 6, 7, 8]
		List<Integer> result = s.subsetSum(nums);
		Collections.sort(result);
		System.out.println(result);
	}

	public List<Integer> subsetSum(int[] nums) {
		List<Integer> result = new ArrayList<>();
		generateSubsetSum(0, nums, 0, result);
		return result;
	}

	private void generateSubsetSum(int index, int[] nums, int sum, List<Integer> result) {
		result.add(sum);
		for (int i = index; i < nums.length; i++) {
			sum = sum + nums[i];
			generateSubsetSum(i + 1, nums, sum, result);
			sum = sum - nums[i];
		}
	}
}
