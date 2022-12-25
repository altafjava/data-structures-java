package com.altafjava.patterns.topkelements;

import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it.</br>
 * Input: [1, 5, 12, 2, 11, 5], K = 3</br>
 * Output: 5</br>
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].</br>
 * </br>
 * Input: [1, 5, 12, 2, 11, 5], K = 4</br>
 * Output: 5</br>
 * Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].</br>
 * </br>
 * Input: [5, 12, 11, -1, 12], K = 3</br>
 * Output: 11</br>
 * Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
 */
public class KthSmallestNumber {

	public static void main(String[] args) {
		int result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
		System.out.println("Kth smallest number is: " + result);
		// since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
		result = findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
		System.out.println("Kth smallest number is: " + result);
		result = findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
		System.out.println("Kth smallest number is: " + result);
	}

	public static int findKthSmallestNumber(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
		for (int i = 0; i < k; i++) {
			maxHeap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		return maxHeap.peek();
	}

}
