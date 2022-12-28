package com.altafjava.patterns.knapsack;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which
 * will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only
 * be selected once, which means either we put an item in the knapsack or we skip it.
 */
public class Knapsack {

	public static void main(String[] args) {
		int profits[] = { 1, 6, 10, 16 }, weights[] = { 1, 2, 3, 5 }, capacity = 7;
		Knapsack knapsack = new Knapsack();
//		int maxProfit = knapsack.solveKnapsack(profits, weights, capacity);
		int maxProfit = knapsack.solveKnapsack_Recursive(profits, weights, capacity);
		System.out.println("Max Profit: " + maxProfit);
//		maxProfit = knapsack.solveKnapsack(profits, weights, 6);
//		System.out.println("Max Profit: " + maxProfit);
	}

	private int solveKnapsack_Recursive(int[] profits, int[] weights, int capacity) {
		return knapsackRecursive(profits, weights, capacity, 0);
	}

	private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex >= profits.length)
			return 0;
		int weight = weights[currentIndex];
		int profit1 = 0;
		if (weight <= capacity) {
			profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weight, currentIndex + 1);

		}
		int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
		return Math.max(profit1, profit2);
	}

	private int solveKnapsack(int[] profits, int[] weights, int capacity) {
		int maxProfit = 0;
		for (int i = 0; i < profits.length - 1; i++) {
			for (int j = i + 1; j < profits.length; j++) {
				int weight = weights[i] + weights[j];
				if (weight <= capacity) {
					int profit = profits[i] + profits[j];
					if (profit > maxProfit)
						maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

}
