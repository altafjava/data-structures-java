package com.altafjava.sorting;

import java.util.Arrays;

public class MergeHalfSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 12, 3, 6, 7, 10 };
		System.out.println("Before Merging: " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("After Merging: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		int n1 = mid - low + 1;
		int n2 = high - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		// Copy data to temporary arrays
		System.arraycopy(arr, low, left, 0, n1);
		System.arraycopy(arr, mid + 1, right, 0, n2);

		int i = 0, j = 0;
		int k = low;

		// Merge the two halves
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		// Copy remaining elements of left[]
		while (i < n1) {
			arr[k++] = left[i++];
		}

		// Copy remaining elements of right[]
		while (j < n2) {
			arr[k++] = right[j++];
		}
	}
}
