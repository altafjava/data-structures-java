package com.altafjava.bootcamp.day06;

/*
 You are given an m x n integer matrix matrix with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Time Complexity: O(log(m * n))
Space Complexity: O(1)
 */
public class Search2dMatrix {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, target = 3;
		boolean result = searchMatrix(matrix, target);
		System.out.println(result);
	}

	static public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int low = 0;
		int high = rows * cols - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
}
