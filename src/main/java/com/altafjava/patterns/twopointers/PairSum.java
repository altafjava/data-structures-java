package com.altafjava.patterns.twopointers;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairSum {
	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 5, 6 }, target = 6;
//		int input[] = { 2, 5, 9, 11 }, target = 11;
		new PairSum().findPairSum2(input, target);
	}

	private void findPairSum(int[] arr, int target) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					System.out.println(arr[i] + "," + arr[j]);
					break;
				}
			}
		}
	}

//	Using two pointers
	private void findPairSum2(int[] arr, int target) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum > target)
				j--;
			else if (sum < target)
				i++;
			else {
				System.out.println(arr[i] + "," + arr[j]);
				i++;
				j--;
			}
		}
	}

//	Using Hashing
	private void findPairSum3(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int a : arr) {
			Integer value = map.get(target - a);
			if (value != null)
				System.out.println(value + "," + a);
			map.put(a, a);
		}
	}
}
