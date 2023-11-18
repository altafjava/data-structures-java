package com.altafjava.bootcamp.day10;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Example 1:
Input : arr[] = {4, 2, 2, 6, 4}, k = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are {4, 2}, {4, 2, 2, 6, 4}, {2, 2, 6}, and {6}

Example 2:
Input : arr[] = {5, 6, 7, 8, 9}, k = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are {5} and {5, 6, 7, 8, 9}
*/
public class NoOfSubarraysWithGivenXor {

	public static void main(String[] args) {
//		int arr[] = { 4, 2, 2, 6, 4 }, k = 6;
		int arr[] = { 5, 6, 7, 8, 9 }, k = 5;
		int count = subarraysWithXorK(arr, k);
		System.out.println(count);
	}

	static public int subarraysWithXorK(int[] arr, int k) {
		int xor = 0, count = 0;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		map.put(0, 1);
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
			int x = xor ^ k;
			if (map.containsKey(x)) {
				count += map.get(x);
			}
			Integer value = map.get(xor);
			if (value == null) {
				map.put(xor, 1);
			} else {
				map.put(xor, value + 1);
			}
		}
		return count;
	}
}
