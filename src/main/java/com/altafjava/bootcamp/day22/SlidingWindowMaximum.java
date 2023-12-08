package com.altafjava.bootcamp.day22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/description/

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
*/
public class SlidingWindowMaximum {

	public static void main(String[] args) {
//		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
		int nums[] = { 1, 3, 1, 2, 0, 5 }, k = 3;
		int[] result = maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(result));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int result[] = new int[nums.length - k + 1], ri = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// Remove elements that are out of the current window
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}
			// Remove elements smaller than the current element from the back
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i >= k - 1)
				result[ri++] = nums[dq.peek()];
		}
		return result;
	}
}
