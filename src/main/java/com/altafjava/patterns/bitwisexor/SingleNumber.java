package com.altafjava.patterns.bitwisexor;

/**
 * In a non-empty array of integers, every number appears twice except for one, find that single number.</br>
 * Input: 1, 4, 2, 1, 3, 2, 3</br>
 * Output: 4</br>
 * </br>
 * Input: 7, 9, 7</br>
 * Output: 9</br>
 */
public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(findSingleNumber(new int[] { 1, 4, 2, 1, 3, 2, 3 }));
		System.out.println(findSingleNumber(new int[] { 7, 9, 7 }));
	}

	/**
	 * Taking XOR of a number with itself returns 0, e.g</br>
	 * 1 ^ 1 = 0</br>
	 * 29 ^ 29 = 0</br>
	 * </br>
	 * Taking XOR of a number with 0 returns the same number, e.g</br>
	 * 1 ^ 0 = 1</br>
	 * 31 ^ 0 = 31</br>
	 * </br>
	 * <b>Time Complexity:</b> Time complexity of this solution is O(n) as we iterate through all numbers of the input
	 * once.</br>
	 * <b>Space Complexity:</b> The algorithm runs in constant space O(1).
	 * 
	 * @param arr
	 * @return
	 */
	private static int findSingleNumber(int[] arr) {
		int num = 0;
		for (int a : arr) {
			num = num ^ a;
		}
		return num;
	}

}
