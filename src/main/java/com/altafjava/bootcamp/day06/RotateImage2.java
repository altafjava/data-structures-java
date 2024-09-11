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
public class RotateImage2 {
    public static void rotateCounterClockwise(int[][] matrix) {
        int size = matrix.length;
        for (int layer = 0; layer < size / 2; layer++) {
            int first = layer;
            int last = size - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[i][last];
                matrix[i][last] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[last - offset][first];
                matrix[last - offset][first] = top;
            }
        }
    }

    public static void main(String[] args) {
		int[][] matrix = { { 8, 2, 3 }, { 2, 9, 1 }, { 9, 0, 6 } };
//		int[][] matrix = { { 1, 2 }, { 3, 4 } };
//		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Before: " + Arrays.deepToString(matrix));
		rotateCounterClockwise(matrix);
		System.out.println("After: " + Arrays.deepToString(matrix));
	}
    
}
