package com.altafjava.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
//		int[] arr = { 5, 7, 6, 9, 4, 8, 1, 2, 3 };
		int[] arr = { 2, 5, 8, 12, 3, 6, 7, 10 };
		System.out.print("-: Merge Sort :-\nBefore Sort: " + Arrays.toString(arr));
		mergeSort(arr);
		System.out.print("\nAfter Sort: " + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		int p = 2, n = arr.length;
		while (p <= n) {
			for (int i = 0; i + p - 1 < n; i = i + p) {
				int low = i;
				int high = i + p - 1;
				int mid = (low + high) / 2;
				merge(arr, low, mid, high);
			}
			p = p * 2;
		}
		if (p / 2 < n) {
			merge(arr, 0, p / 2 - 1, n - 1);
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
