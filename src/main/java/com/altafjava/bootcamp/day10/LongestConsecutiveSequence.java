package com.altafjava.bootcamp.day10;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
//		int[] nums = { 100, 4, 200, 1, 3, 2 };
//		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
//		int[] nums = { 0, -1 };
		int[] nums = { 0 };
		int longestConsecutive = longestConsecutive(nums);
		System.out.println(longestConsecutive);
	}

	static public int longestConsecutive(int[] nums) {
		Set<Integer> hashSet = new HashSet<>();
		for (int n : nums)
			hashSet.add(n);
		int max = 0, cur = 0;
		for (int n : nums) {
			// If the current element is the start of a sequence
			if (!hashSet.contains(n - 1)) {
				cur = 1;
				int cn = n + 1;
				while (hashSet.contains(cn)) {
					cur++;
					cn++;
				}
			}
			max = Math.max(max, cur);
			cur = 0;
		}
		return max;
	}

	/* This will get Time Limit Exceeded if the array length is greater than 65536 */
//	static public int longestConsecutive(int[] nums) {
//		Set<Integer> hashSet = new HashSet<>();
//		for (int n : nums)
//			hashSet.add(n);
//		int max = 0, cur = 0;
//		for (int n : nums) {
//			if (hashSet.contains(n + 1)) {
//				cur++;
//				int cn = n + 1;
//				while (hashSet.contains(cn)) {
//					cur++;
//					cn++;
//				}
//			} else {
//				cur = 1;
//			}
//			max = Math.max(max, cur);
//			cur = 0;
//		}
//		return max;
//	}

	/* This will not work for negative values */
//	static public int longestConsecutive(int[] nums) {
//		int high = 0;
//		for (int n : nums)
//			high = Math.max(high, n);
//		high = Math.max(high, nums.length);
//		int[] hash = new int[high + 1];
//		for (int i = 0; i < nums.length; i++) {
//			hash[nums[i]] = 1;
//		}
//		int max = 0, cur = 0;
//		for (int i = 0; i < hash.length - 1; i++) {
//			if (hash[i] > 0) {
//				if (i > 0 && hash[i - 1] > 0) {
//					cur++;
//				} else {
//					cur = 1;
//				}
//			}
//			if (cur > max)
//				max = cur;
//		}
//		return max;
//	}

}
