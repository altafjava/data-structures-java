package com.altafjava.patterns.topkelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.</br>
 * Input: [1, 3, 5, 12, 11, 12, 11 ], K = 2</br>
 * Output: [11, 12]</br>
 * </br>
 * Input: [3, 5, 7, 3, 11], K = 2</br>
 * Output: [3, 5]</br>
 */
public class TopKFrequentNumbers {

	public static void main(String[] args) {
		List<Integer> result = findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
		result = findTopKFrequentNumbers(new int[] { 3, 5, 7, 3, 11 }, 2);
		System.out.println("Here are the K frequent numbers: " + result);
	}

	/**
	 * <b>Time Complexity:</b> The time complexity of the above algorithm is O(N+N*logK).</br>
	 * <b>Space Complexity:</b> The space complexity will be O(N)).</br>
	 * Even though we are storing only ‘K’ numbers in the heap. For the frequency map, however, we need to store all the ‘N’
	 * numbers.</br>
	 * </br>
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	private static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
			if (i < k) {
				minHeap.add(nums[i]);
			}
		}
		for (int i = k; i < nums.length; i++) {
			if (frequencyMap.get(nums[i]) > frequencyMap.get(minHeap.peek())) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return new ArrayList<>(minHeap);
	}

}
