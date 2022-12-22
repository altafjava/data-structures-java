package com.altafjava.patterns.slidingwindow;

import java.util.Arrays;

/*
Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class ContiguousSubArray {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, k = 5;
		double[] result = new ContiguousSubArray().findContigousSubArray2(arr, k);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * A brute-force algorithm will be to calculate the sum of every 5-element contiguous subarray of the given array and
	 * divide the sum by ‘5’ to find the average. This is what the algorithm will look like. Time complexity: Since for
	 * every element of the input array, we are calculating the sum of its next ‘K’ elements, the time complexity of the
	 * above algorithm will be O(N*K)O(N∗K) where ‘N’ is the number of elements in the input array.
	 */
	public double[] findContigousSubArray(int[] arr, int k) {
		int limit = arr.length - k;
		double[] result = new double[limit + 1];
		for (int i = 0; i <= limit; i++) {
			double sum = 0;
			for (int j = i; j < k + i; j++) {
				sum += arr[j];
			}
			result[i] = sum / k;
		}
		return result;
	}

	/*
	 * Solution using Sliding Window. Time Complexity: O(n)
	 */
	public double[] findContigousSubArray2(int[] arr, int k) {
		int windowStart = 0, limit = arr.length - k;
		double sum = 0, result[] = new double[limit + 1];
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];
			if (windowEnd >= k - 1) {
				result[windowStart] = sum / k;
				sum = sum - arr[windowStart];
				windowStart++;
			}
		}
		return result;
	}
}
