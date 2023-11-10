package com.altafjava.bootcamp.day6;

import java.util.Arrays;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:
    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1

Follow up:
    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?

 */
public class SetMatrixZero {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println("Before: " + Arrays.deepToString(matrix));
		setZeroes(matrix);
		System.out.println("After: " + Arrays.deepToString(matrix));
	}

	static public void setZeroes(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		boolean isRow0 = false, isCol0 = false;
		for (int j = 0; j < cols; j++) {
			if (matrix[0][j] == 0)
				isRow0 = true;
		}
		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0)
				isCol0 = true;
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		if (isRow0) {
			for (int j = 0; j < cols; j++)
				matrix[0][j] = 0;
		}
		if (isCol0) {
			for (int i = 0; i < rows; i++)
				matrix[i][0] = 0;
		}
	}
}
