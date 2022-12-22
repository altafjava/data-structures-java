package com.altafjava.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 7, 2, 1, 0, 9, 6 };
		int[] arr = { 5, 7, 6, 9, 4, 8, 1, 2, 3 };
		System.out.print("-: Quick Sort :-\nBefore Sort: ");
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
//		System.out.print("\nAfter Sort: " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int j = partition(arr, low, high);
			quickSort(arr, low, j - 1);
			quickSort(arr, j + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low], i = low, j = high;
		do {
			while (arr[i] <= pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j)
				swap(arr, i, j);
//			System.out.println(Arrays.toString(arr));
		} while (i < j);
		swap(arr, low, j);
		System.out.println(Arrays.toString(arr));
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
