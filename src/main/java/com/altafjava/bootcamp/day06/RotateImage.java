package com.altafjava.bootcamp.day06;

import java.util.Arrays;

/*
You are given an n×nn×n 2D matrix representing an image. Rotate the image by 90 degrees counterclockwise.
You must rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix for the rotation.

Example 1:
Input: matrix = [8, 2, 3],[2, 9, 1],[9, 0, 6]]
Output: [[3, 1, 6],[2, 9, 0],[8, 2, 9]]

Example 2:
Input: matrix = [[1, 2],[3, 4]]
Output: [[2, 4],[1, 3]

Example 3:
Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: [[3, 6, 9], [2, 5, 8], [1, 4, 7]]

Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000

Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class RotateImage {
	static public void rotateCounterClockwise(int[][] matrix) {
		int n = matrix.length;

		// Step 1: Reverse the rows
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
		// Step 2: Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
//		int[][] matrix = { { 8, 2, 3 }, { 2, 9, 1 }, { 9, 0, 6 } };
//		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Before: " + Arrays.deepToString(matrix));
		rotateCounterClockwise(matrix);
		System.out.println("After: " + Arrays.deepToString(matrix));
	}

}
