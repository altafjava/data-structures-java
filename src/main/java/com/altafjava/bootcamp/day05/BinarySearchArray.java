package com.altafjava.bootcamp.day05;

/**
 * Search an element in the Sorted Array
 */
public class BinarySearchArray {

	public static int binarySearch(int[] arr, int key) {
		int l = 0, h = arr.length - 1, m = 0;
		while (l <= h) {
			m = (l + h) / 2;
			if (key == arr[m])
				return m;
			else if (key < arr[m])
				h = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 5, 6, 7, 8, 9, 10 }, key = 8;
		int index = binarySearch(arr, key);
		System.out.println("Element " + key + " present in the index: " + index);
	}
}
