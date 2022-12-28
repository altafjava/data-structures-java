package com.altafjava.patterns.kwaymerge;

import java.util.PriorityQueue;

/**
 * Given an N * N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the
 * matrix.</br>
 * Input: Matrix=[</br>
 * [2, 6, 8],</br>
 * [3, 7, 10],</br>
 * [5, 8, 11]</br>
 * ],</br>
 * K=5</br>
 * Output: 7</br>
 * Explanation: The 5th smallest number in the matrix is 7.</br>
 */
public class KthSmallestNumberInSortedMatrix {

	public static void main(String[] args) {
		int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } }, k = 5;
		int smallest = findKthSmallest(matrix, k);
		System.out.println(smallest);
	}

	/**
	 * <b>Time Complexity: </b>First, we inserted at most ‘K’ or one element from each of the ‘N’ rows, which will take
	 * O(min(K, N)). Then we went through at most ‘K’ elements in the matrix and remove/add one element in the heap in each
	 * step. As we can’t have more than ‘N’ elements in the heap in any condition, therefore, the overall time complexity of
	 * the above algorithm will be O(min(K, N) + K*logN).</br>
	 * <b>Space Complexity: </b>The space complexity will be O(N) because, in the worst case, our min-heap will be storing
	 * one number from each of the ‘N’ rows. </br>
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(
				(n1, n2) -> (matrix[n1.arrayIndex][n1.elementIndex] - matrix[n2.arrayIndex][n2.elementIndex]));
		for (int i = 0; i < matrix.length; i++) {
			minHeap.add(new ArrayNode(i, 0));
		}
		int count = 0;
		while (!minHeap.isEmpty()) {
			ArrayNode node = minHeap.poll();
			if (++count == k) {
				return matrix[node.arrayIndex][node.elementIndex];
			} else {
				node.elementIndex++;
				if (matrix[node.arrayIndex].length > node.elementIndex) {
					minHeap.add(node);
				}
			}
		}
		return -1;
	}

}
