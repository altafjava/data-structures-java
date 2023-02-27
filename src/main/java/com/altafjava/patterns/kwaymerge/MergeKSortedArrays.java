package com.altafjava.patterns.kwaymerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of �K� sorted arrays, merge them into one sorted list.
 * 
 */
public class MergeKSortedArrays {

	public static void main(String[] args) {
		Integer[] l1 = { 2, 6, 8, 11 };
		Integer[] l2 = { 3, 5, 7, 9, 12 };
		Integer[] l3 = { 1, 3, 4 };
		Integer[] result = mergeSortedArrays(Arrays.asList(l1, l2, l3));
		System.out.println(Arrays.toString(result));
	}

	private static Integer[] mergeSortedArrays(List<Integer[]> list) {
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(
				(n1, n2) -> list.get(n1.arrayIndex)[n1.elementIndex] - list.get(n2.arrayIndex)[n2.elementIndex]);
		int size = 0, k = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length > 0) {
				minHeap.add(new ArrayNode(i, 0));
			}
			size = size + list.get(i).length;
		}
		Integer[] result = new Integer[size];
		while (!minHeap.isEmpty()) {
			ArrayNode node = minHeap.poll();
			result[k++] = list.get(node.arrayIndex)[node.elementIndex];
			node.elementIndex++;
			if (list.get(node.arrayIndex).length > node.elementIndex) {
				minHeap.add(node);
			}
		}
		return result;
	}
}
