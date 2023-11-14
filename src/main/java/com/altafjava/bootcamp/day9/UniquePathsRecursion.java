package com.altafjava.bootcamp.day9;

/*
62. Unique Paths
https://leetcode.com/problems/unique-paths/description/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach
the bottom-right corner. The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
    1 <= m, n <= 100
*/
public class UniquePathsRecursion {

	public static void main(String[] args) {
		UniquePathsRecursion solution = new UniquePathsRecursion();
//		int m = 3, n = 7;
//		System.out.println(solution.uniquePaths(m, n)); // Output: 28
//		int m = 3, n = 2;
//		System.out.println(solution.uniquePaths(m, n)); // Output: 3
		int m = 23, n = 12;
		System.out.println(solution.uniquePaths(m, n)); // Output: 193536720
	}

	private int uniquePaths(int m, int n) {
		// Call the recursive function starting from the bottom-right corner.
		return countPaths(m - 1, n - 1);
	}

	private int countPaths(int row, int col) {
		// Check if we have reached the top-left corner.
		if (row == 0 && col == 0) {
			return 1;
		}
		int upPaths = 0, leftPaths = 0;
		// Move up if within bounds.
		if (row - 1 >= 0) {
			upPaths = countPaths(row - 1, col);
		}
		// Move left if within bounds.
		if (col - 1 >= 0) {
			leftPaths = countPaths(row, col - 1);
		}
		// Sum the paths.
		return upPaths + leftPaths;
	}

}
