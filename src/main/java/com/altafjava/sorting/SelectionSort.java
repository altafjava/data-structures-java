package com.altafjava.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 8, 6, 3, 10, 9, 4, 12, 5, 2, 7 };
		System.out.print("-: Selection Sort :-\nBefore Sort: ");
		print(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int k = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		System.out.print("\nAfter Sort: ");
		print(arr);
	}

	public static void print(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}
