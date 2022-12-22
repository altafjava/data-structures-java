package com.altafjava.patterns.bitwisexor;

/**
 * Given an array of n-1 integers in the range from 1 to n, find the one number that is missing from the array.
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 6, 4 };
		System.out.println("Missing number is: " + findMissingNumber(arr));
	}

	/**
	 * Remember the important property of XOR that it returns 0 if both the bits in comparison are the same. In other words,
	 * XOR of a number with itself will always result in 0. This means that if we XOR all the numbers in the input array
	 * with all numbers from the range 11 to nn then each number in the input is going to get zeroed out except the missing
	 * number.</br>
	 * </br>
	 * <b>Time & Space complexity:</b> The time complexity of the above algorithm is O(n) and the space complexity is O(1).
	 * The time and space complexities are the same as that of the previous solution but, in this algorithm, we will not
	 * have any integer overflow problem.
	 * 
	 * @param arr
	 * @return int
	 */
	private static int findMissingNumber(int[] arr) {
		int n = arr.length + 1;
		int x1 = 1;
		for (int i = 2; i <= n; i++) {
			x1 = x1 ^ i;
		}
		int x2 = arr[0];
		for (int i = 1; i < arr.length; i++) {
			x2 = x2 ^ arr[i];
		}
		return x1 ^ x2;
	}

}
