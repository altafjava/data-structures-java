package com.altafjava.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 8, 5, 7, 9, 4 };
		System.out.print("-: Bubble Sort :-\nBefore Sort: ");
		print(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
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
