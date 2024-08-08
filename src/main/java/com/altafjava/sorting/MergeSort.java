package com.altafjava.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
		int[] arr = { 5, 7, 6, 9, 4, 8, 1, 2, 3 };
//		int[] arr = { 2, 5, 8, 12, 3, 6, 7, 10 };
		System.out.print("-: Merge Sort :-\nBefore Sort: " + Arrays.toString(arr));
		mergeSort(arr);
		System.out.print("\nAfter Sort: " + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		int n = arr.length;
		for (int size = 1; size < n; size = 2 * size) {
			for (int low = 0; low < n - 1; low += 2 * size) {
				int high = Math.min(low + 2 * size - 1, n - 1);
				/*
				 * The mid value in the context of merge sort is meant to represent the point
				 * where an array (or subarray) is divided into two halves for merging. The
				 * value of mid should be the index where the first half ends and the second
				 * half begins.
				 */
				int mid = low + size - 1;
				merge(arr, low, mid, high);
			}
		}
	}

	private static void merge(int[] A, int low, int mid, int high) {
		int i = low, j = mid + 1, k = low;
		int[] B = new int[high + 1];
		while (i <= mid && j <= high) {
			if (A[i] < A[j]) {
				B[k++] = A[i++];
			} else {
				B[k++] = A[j++];
			}
		}
		while (i <= mid) {
			B[k++] = A[i++];
		}
		while (j <= high) {
			B[k++] = A[j++];
		}
		for (int a = low; a <= high; a++) {
			A[a] = B[a];
		}
	}
}
