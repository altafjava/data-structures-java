package com.altafjava.patterns.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the median number among all arrays.
 */
public class Median {

	public static void main(String[] args) {
		Integer[] l1 = { 2, 6, 8, 11 };
		Integer[] l2 = { 3, 5, 7, 9, 12 };
		Integer[] l3 = { 1, 3, 4 };
		double median = findMedian(List.of(l1, l2, l3));
		System.out.println(median);
	}

	public static double findMedian(List<Integer[]> list) {
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(
				(n1, n2) -> (list.get(n1.arrayIndex)[n1.elementIndex] - list.get(n2.arrayIndex)[n2.elementIndex]));
		int n = 0;
		for (int i = 0; i < list.size(); i++) {
			minHeap.add(new ArrayNode(i, 0));
			n = n + list.get(i).length;
		}
		int count = 0, k = n / 2;
		double median = 0;
		ArrayNode prev = null;
		while (!minHeap.isEmpty()) {
			ArrayNode node = minHeap.poll();
			if (count++ == k) {
				median = list.get(node.arrayIndex)[node.elementIndex];
				if (n % 2 == 0) {
					median = (list.get(node.arrayIndex)[node.elementIndex] + list.get(prev.arrayIndex)[prev.elementIndex]) / 2.0;
				}
				break;
			} else {
				prev = new ArrayNode(node.arrayIndex, node.elementIndex);
				node.elementIndex++;
				if (list.get(node.arrayIndex).length > node.elementIndex) {
					minHeap.add(node);
				}
			}
		}
		return median;
	}
}
