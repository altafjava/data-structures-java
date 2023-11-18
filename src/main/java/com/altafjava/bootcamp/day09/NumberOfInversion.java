package com.altafjava.bootcamp.day09;

/*
Number of Inversions 
https://www.codingninjas.com/studio/problems/number-of-inversions_6840276

Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
What is an inversion of an array?
Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find
a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5
so this is not an inversion.

Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find
a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 
which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.
For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 7
Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4)
as both are not satisfy our condition. 

Time Complexity: O(n log n)
space complexity: O(n)
*/
public class NumberOfInversion {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 2, 1, 4 };// 7
//		int[] nums = { 1, 2, 3, 4, 5 };// 0
//		int[] nums = { 5, 4, 3, 2, 1 };// 10
		int numberOfInversions = numberOfInversions(nums, 0, nums.length - 1);
		System.out.println(numberOfInversions);
	}

	private static int numberOfInversions(int[] nums, int low, int high) {
		int count = 0;
		if (low >= high)
			return count;
		int mid = (low + high) / 2;
		count += numberOfInversions(nums, low, mid);
		count += numberOfInversions(nums, mid + 1, high);
		count += sortAndMerge(nums, low, mid, high);
		return count;
	}

	private static int sortAndMerge(int[] nums, int low, int mid, int high) {
		int left = low, right = mid + 1, count = 0;
		int temp[] = new int[high - low + 1], k = 0;
		while (left <= mid && right <= high) {
			if (nums[left] <= nums[right]) {
				temp[k++] = nums[left++];
			} else {
				temp[k++] = nums[right++];
				count += mid - left + 1;
			}
		}
		while (left <= mid)
			temp[k++] = nums[left++];
		while (right <= high)
			temp[k++] = nums[right++];
		left = low;
		right = mid + 1;
		for (int i = low; i <= high; i++)
			nums[i] = temp[i - low];
		return count;
	}

}
