package com.altafjava.bootcamp.day02;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 8, 5, 2, 3, 9, 1 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int k = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
	}
}
