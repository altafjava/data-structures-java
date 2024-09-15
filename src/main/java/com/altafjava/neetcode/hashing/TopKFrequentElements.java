package com.altafjava.neetcode.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/description/

Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class TopKFrequentElements {

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3 }, k = 2;
//		int nums[] = { 1 }, k = 1;
		int[] topKFrequent = topKFrequent(nums, k);
		System.out.println(Arrays.toString(topKFrequent));
	}

	static public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}
		List<Integer>[] buckets = new List[nums.length + 1];
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			int key = entry.getKey();
			int frequency = entry.getValue();
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(key);
		}
		int[] result = new int[k];
		int index = 0;
		for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
			if (buckets[i] != null) {
				for (int num : buckets[i]) {
					result[index++] = num;
				}
			}
		}
		return result;
	}
}
