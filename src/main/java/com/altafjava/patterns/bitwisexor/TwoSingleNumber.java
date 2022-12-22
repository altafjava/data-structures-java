package com.altafjava.patterns.bitwisexor;

import java.util.Arrays;

/**
 * In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once. Find
 * the two numbers that appear only once.</br>
 * Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]</br>
 * Output: [4, 6]</br>
 * </br>
 * Input: [2, 1, 3, 2]</br>
 * Output: [1, 3]</br>
 * </br>
 * Input: [1, 4, 1, 3, 2, 3 ]</br>
 * Output: [4, 2]</br>
 */
public class TwoSingleNumber {

	public static void main(String[] args) {
//		int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
//		int[] arr = new int[] { 1, 4, 1, 5 };
		int[] arr = { 1, 4, 1, 3, 2, 3 };
//		int[] arr = new int[] { 2, 1, 3, 2 };
		System.out.println(Arrays.toString(findSingleNumbers(arr)));
	}

	/**
	 * <b>Time Complexity:</b> The time complexity of this solution is O(n) where ‘n’ is the number of elements in the input
	 * array.</br>
	 * <b>Space Complexity:</b> The algorithm runs in constant space O(1).
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] findSingleNumbers(int[] arr) {
		int n1xn2 = 0;
		for (int a : arr) {
			n1xn2 = n1xn2 ^ a;
		}
		int rightMostBit = 1;
		while ((rightMostBit & n1xn2) == 0) {
			rightMostBit = rightMostBit << 1;
		}
		int num1 = 0, num2 = 0;
		for (int a : arr) {
			if ((rightMostBit & a) == 0)
				num1 = num1 ^ a;
			else
				num2 = num2 ^ a;
		}
		return new int[] { num1, num2 };
	}

}
