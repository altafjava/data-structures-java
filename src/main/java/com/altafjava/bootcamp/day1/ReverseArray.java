package com.altafjava.bootcamp.day1;

import java.util.Arrays;

//Reverse the array in place (space complexity should be constant)
//Input —>> 3,5,9,4,2
//Output —>> 2,4,9,5,3
public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 9, 4, 2 };
		System.out.println("Before: " + Arrays.toString(arr));
		int[] reverse = reverseInplace(arr);
		System.out.println("Before: " + Arrays.toString(reverse));
	}

	public static int[] reverseInplace(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = temp;
		}
		return arr;
	}

	public static int[] reverse(int[] arr) {
		int[] temp = new int[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			temp[j++] = arr[i];
		}
		return temp;
	}
}
