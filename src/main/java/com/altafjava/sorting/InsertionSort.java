package com.altafjava.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		System.out.print("-: Insertion Sort :-\nBefore Sort: ");
		int[] arr = { 8, 5, 7, 9, 4 };
		print(arr);
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
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
