package com.altafjava.sorting;

import java.util.Arrays;

public class MergeSortRecursive {

	public static void main(String[] args) {
//		int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
//		int[] arr = { 5, 7, 6, 9, 4, 8, 1, 2, 3 };
		int[] arr = { 2, 5, 8, 12, 3, 6, 7, 10 };
		System.out.print("-: Merge Sort :-\nBefore Sort: " + Arrays.toString(arr));
		int low = 0;
		int high = arr.length - 1;
		mergeSort(arr, low, high);
		System.out.print("\nAfter Sort: " + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] brr = new int[arr.length];
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j])
				brr[k++] = arr[i++];
			else
				brr[k++] = arr[j++];
		}
		while (i <= mid)
			brr[k++] = arr[i++];
		while (j <= high)
			brr[k++] = arr[j++];
		for (i = low; i <= high; i++)
			arr[i] = brr[i];
	}

}
