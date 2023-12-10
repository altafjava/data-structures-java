package com.altafjava.bootcamp.day26;

import java.util.ArrayList;
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

Constraints:
1 <= N <= 15
0 <= arr[i] <= 10^4

Time Complexity: O(N * 2^N)
Space Complexity: O(N * 2^N)
*/
public class SubsetSumIterative {

	public static void main(String[] args) {
		SubsetSumIterative s = new SubsetSumIterative();
		int[] nums = { 1, 2, 3 };
		List<Integer> result = s.subsetSum(nums);
		System.out.println(result);
	}

	public List<Integer> subsetSum(int[] nums) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for (int num : nums) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				result.add(result.get(j) + num);
			}
		}
		return result;
	}

}
