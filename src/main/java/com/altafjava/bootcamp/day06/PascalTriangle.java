package com.altafjava.bootcamp.day06;

import java.util.ArrayList;
import java.util.List;

/*
118. Given an integer numRows, return the first numRows of Pascal's triangle.
https://leetcode.com/problems/pascals-triangle/description/

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
    1 <= numRows <= 30

Time Complexity: O(numRows^2) = O(n^2)
Space complexity: O(numRows^2) = O(n^2)
*/

public class PascalTriangle {

	public static void main(String[] args) {
		int numRows1 = 5;
		List<List<Integer>> triangle1 = generate(numRows1);
		System.out.println(triangle1);

		int numRows2 = 1;
		List<List<Integer>> triangle2 = generate(numRows2);
		System.out.println(triangle2);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		result.get(0).add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			// First element in each row is always 1
			row.add(1);
			// Calculate the middle elements
			List<Integer> prevRows = result.get(i - 1);
			for (int j = 1; j < i; j++) {
				row.add(prevRows.get(j - 1) + prevRows.get(j));
			}
			// Last element in each row is always 1
			row.add(1);
			result.add(row);
		}
		return result;
	}

}
