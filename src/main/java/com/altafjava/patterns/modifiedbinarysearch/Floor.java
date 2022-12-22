package com.altafjava.patterns.modifiedbinarysearch;

/**
 * Given an array of numbers sorted in an ascending order, find the floor of a given number ‘key’. The floor of the
 * ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.</br>
 * Write a function to return the index of the floor of the ‘key’. If there isn’t any floor return -1.
 */
public class Floor {

	public static void main(String[] args) {
		System.out.println(searchFloor(new int[] { 4, 6, 10 }, 6));
		System.out.println(searchFloor(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(searchFloor(new int[] { 4, 6, 10 }, 17));
		System.out.println(searchFloor(new int[] { 4, 6, 10 }, -1));
		System.out.println(searchFloor(new int[] { 1, 5, 8, 10, 15 }, 3));
	}

	/**
	 * <b>Time Complexity:</b>Since we are reducing the search range by half at every step, this means that the time
	 * complexity of our algorithm will be O(logN) where ‘N’ is the total elements in the given array.</br>
	 * <b>Space Complexity:<b/>The algorithm runs in constant space O(1)O(1).
	 * 
	 * @param arr
	 * @param key
	 * @return index
	 */
	private static int searchFloor(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		if (key < arr[start])
			return -1;
		boolean isAscending = arr[start] < arr[end];
		while (start <= end) {
			int mid = start + (end - start) / 2;
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
		return end;
	}
}
