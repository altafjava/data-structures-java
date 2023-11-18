package com.altafjava.bootcamp.day02;

import java.util.Arrays;

public class QuickSort {

	public static void main(String args[]) {
		int[] arr = { 3, 8, 2, 1, 4, 9, 7 };
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	// method to find the partition position
	static int partition(int array[], int lowIndex, int highIndex) {
		// choose the rightmost element as pivot
		int pivot = array[highIndex];
		// pointer for greater element
		int i = (lowIndex - 1);
		// traverse through all elements compare each element with pivot
		for (int j = lowIndex; j < highIndex; j++) {
			if (array[j] <= pivot) {
				// if element smaller than pivot is found swap it with the greater element pointed by i
				i++;
				// swapping element at i with element at j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// swap the pivot element with the greater element specified by i
		int temp = array[i + 1];
		array[i + 1] = array[highIndex];
		array[highIndex] = temp;
		// return the position from where partition is done
		return (i + 1);
	}

	static void quickSort(int array[], int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			// find pivot element such that elements smaller than pivot are on the left elements greater than pivot are on the right
			int pi = partition(array, lowIndex, highIndex);
			// recursive call on the left of pivot
			quickSort(array, lowIndex, pi - 1);
			// recursive call on the right of pivot
			quickSort(array, pi + 1, highIndex);
		}
	}
}
