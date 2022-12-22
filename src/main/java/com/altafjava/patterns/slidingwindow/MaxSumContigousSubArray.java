package com.altafjava.patterns.slidingwindow;

/*
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumContigousSubArray {

	public static void main(String[] args) {
		int input[] = { 2, 1, 5, 1, 3, 2 }, k = 3;
//		int input[] = { 2, 3, 4, 1, 5 }, k = 2;
		int result = new MaxSumContigousSubArray().findMaxSumContigousSubArray(input, k);
		System.out.println(result);
	}

	/*
	 * Time Complexity: O(n), Space Complexity: O(1)
	 */
	public int findMaxSumContigousSubArray(int[] arr, int k) {
		int windowStart = 0, sum = 0, max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (i >= k - 1) {
				if (sum > max)
					max = sum;
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		return max;
	}
}
