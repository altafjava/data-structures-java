package com.altafjava.bootcamp.day02;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 8, 5, 2, 3, 9, 1 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int x = arr[i];
			while (j > -1 && arr[j] > x) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = x;
		}
	}
}
