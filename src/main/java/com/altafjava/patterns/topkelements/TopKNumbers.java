package com.altafjava.patterns.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.</br>
 * Input: [3, 1, 5, 12, 2, 11], K = 3</br>
 * Output: [5, 12, 11]</br>
 * </br>
 * Input: [5, 12, 11, -1, 12], K = 3</br>
 * Output: [12, 11, 12]</br>
 */
public class TopKNumbers {

	public static void main(String[] args) {
		List<Integer> largestNumbers = findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println(largestNumbers);
	}

	/**
	 * A brute force solution could be to sort the array and return the largest K numbers. The time complexity of such an
	 * algorithm will be O(N*logN) as we need to use a sorting algorithm like Timsort if we use Java’s
	 * Collection.sort().</br>
	 * </br>
	 * <b>Time Complexity:</b> As discussed above, it will take us O(logK) to extract the minimum number from the min-heap.
	 * So the overall time complexity of our algorithm will be O(K*logK+(N-K)*logK) since, first, we insert ‘K’ numbers in
	 * the heap and then iterate through the remaining numbers and at every step, in the worst case, we need to extract the
	 * minimum number and insert a new number in the heap. This algorithm is better than O(N*logN).</br>
	 * <b>Space Complexity:</b> The space complexity will be O(K) since we need to store the top ‘K’ numbers in the
	 * heap.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	private static List<Integer> findKLargestNumbers(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
		for (int i = 0; i < k; i++) {
			minHeap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return new ArrayList<>(minHeap);
	}

}
