package com.altafjava.patterns.topkelements;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. The cost
 * of connecting two ropes is equal to the sum of their lengths.</br>
 * Input: [1, 3, 11, 5]</br>
 * Output: 33</br>
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)</br>
 * </br>
 * Input: [3, 4, 5, 6]</br>
 * Output: 36</br>
 * Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)</br>
 * </br>
 * Input: [1, 3, 11, 5, 2]</br>
 * Output: 42</br>
 * Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)</br>
 */
public class ConnectRopes {

	/**
	 * <b>Time Complexity:</b> Given ‘N’ ropes, we need O(N*logN) to insert all the ropes in the heap. In each step, while
	 * processing the heap, we take out two elements from the heap and insert one. This means we will have a total of ‘N’
	 * steps, having a total time complexity of O(N*logN).</br>
	 * <b>Space Complexity</b>The space complexity will be O(N) because we need to store all the ropes in the heap.
	 * 
	 * @param ropeLengths
	 * @return
	 */
	public static int minimumCostToConnectRopes(int[] ropeLengths) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		for (int a : ropeLengths) {
			minHeap.add(a);
		}
		int cost = 0;
		while (minHeap.size() > 1) {
			int sum = minHeap.poll() + minHeap.poll();
			cost = cost + sum;
			minHeap.add(sum);
		}
		return cost;
	}

	public static void main(String[] args) {
//		int result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
//		System.out.println("Minimum cost to connect ropes: " + result);
//		result = minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
//		System.out.println("Minimum cost to connect ropes: " + result);
		int result = minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}
}
