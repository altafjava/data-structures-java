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
public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths solution = new UniquePaths();
		// Example 1
		int m1 = 3, n1 = 7;
		System.out.println(solution.uniquePaths(m1, n1)); // Output: 28

		// Example 2
		int m2 = 3, n2 = 2;
		System.out.println(solution.uniquePaths(m2, n2)); // Output: 3
	}

	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
		for (int i = 0; i < n; i++)
			paths[m - 1][i] = 1;
		for (int j = m - 2; j >= 0; j--)
			paths[j][n - 1] = 1;
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
			}
		}
		return paths[0][0];
	}

}
