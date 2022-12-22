package com.altafjava.patterns.cyclicsort;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
//		int arr[] = { 3, 1, 5, 4, 2 };
//		int[] arr = { 2, 6, 4, 3, 1, 5 };
		int[] arr = { 1, 5, 6, 4, 3, 2 };
		new CyclicSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void sort(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			int index = arr[i] - 1;
			if (i != index) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			} else {
				i++;
			}
		}
	}

}
