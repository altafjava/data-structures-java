package com.altafjava.bootcamp.day22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray) of
size k. If a window does not contain a negative integer, then print 0 for that window.

Example:
Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
Output : -8 0 -6 -6

First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
Output : -1 -1 -7 -15 -15 0
 */
public class FirstNegativeNumber {

	public static void main(String[] args) {
		int arr[] = { -8, 2, 3, -6, 10 }, k = 3;
		int[] result = firstNegativeNumber(arr, k);
		System.out.println(Arrays.toString(result));
	}

	public static int[] firstNegativeNumber(int[] nums, int k) {
		int result[] = new int[nums.length - k + 1], ri = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				dq.offer(i);
			}
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}
			if (i >= k - 1)
				result[ri++] = !dq.isEmpty() ? nums[dq.peek()] : 0;
		}
		return result;
	}
}
