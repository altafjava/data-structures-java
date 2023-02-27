package com.altafjava.patterns.kwaymerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.</br>
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]</br>
 * Output: 4</br>
 * </br>
 * Input: L1=[5, 8, 9], L2=[1, 7]</br>
 * Output: 7</br>
 */
public class KthSmallestNumberInMSortedList {

	public static void main(String[] args) {
//		Integer[] l1 = { 2, 6, 8 };
//		Integer[] l2 = { 3, 6, 7 };
//		Integer[] l3 = { 1, 3, 4 };
//		List<Integer[]> lists = List.of(l1, l2, l3);
//		int result = findKthSmallestNumber(lists, 5);
		Integer[] l1 = { 5, 8, 9 };
		Integer[] l2 = { 1, 7 };
		List<Integer[]> lists = Arrays.asList(l1, l2);
		int result = findKthSmallestNumber(lists, 3);
		System.out.println("Kth smallest number: " + result);

	}

	/**
	 * <b>Time Complexity: </b>Since we’ll be going through at most ‘K’ elements among all the arrays, and we will
	 * remove/add one element in the heap in each step, the time complexity of the above algorithm will be O(K*logM) where
	 * ‘M’ is the total number of input arrays.</br>
	 * <b>Space Complexity: </b>The space complexity will be O(M) because, at any time, our min-heap will be storing one
	 * number from all the ‘M’ input arrays.</br>
	 * 
	 * @param lists
	 * @return
	 */
	private static int findKthSmallestNumber(List<Integer[]> lists, int k) {
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(
				(n1, n2) -> (lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]));
		for (int i = 0; i < lists.size(); i++) {
			if (minHeap.size() < k)
				minHeap.add(new ArrayNode(i, 0));
		}
		int result = 0, numberCount = 0;
		while (!minHeap.isEmpty()) {
			ArrayNode old = minHeap.poll();
			if (++numberCount == k) {
				result = lists.get(old.arrayIndex)[old.elementIndex];
				break;
			}
			if (lists.get(old.arrayIndex).length - 1 > old.elementIndex) {
				old.elementIndex++;
				minHeap.add(old);
			}
		}
		return result;
	}
}


