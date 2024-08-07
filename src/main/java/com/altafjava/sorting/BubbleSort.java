package com.altafjava.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 8, 5, 7, 9, 4 };
		System.out.print("-: Bubble Sort :-\nBefore Sort: ");
		print(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
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
