package com.altafjava.bootcamp.day02;

import java.util.Arrays;

public class Test {

	public static void main(String args[]) {
		int[] arr = { 3, 8, 2, 1, 4, 9, 7 };
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int pi = parition(arr, lowIndex, highIndex);
			quickSort(arr, lowIndex, pi - 1);
			quickSort(arr, pi + 1, highIndex);
		}
	}

	private static int parition(int[] arr, int lowIndex, int highIndex) {
		int pivot = arr[highIndex];
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, highIndex);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
