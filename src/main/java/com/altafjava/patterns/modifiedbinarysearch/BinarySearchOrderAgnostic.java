package com.altafjava.patterns.modifiedbinarysearch;

/**
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array. Though we know that the array
 * is sorted, we don’t know if it’s sorted in ascending or descending order. You should assume that the array can have
 * duplicates.</br>
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 */
public class BinarySearchOrderAgnostic {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { 2, 3, 5, 6, 9, 10 }, 9));
		System.out.println(binarySearch(new int[] { 10, 9, 6, 5, 3, 2 }, 9));
	}

	private static int binarySearch(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		boolean isAscending = arr[start] < arr[end];
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == arr[mid])
				return mid;
			if (key > arr[mid]) {
				if (isAscending)
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				if (isAscending)
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return -1;
	}
}
