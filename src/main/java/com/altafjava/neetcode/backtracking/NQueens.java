package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
51. N-Queens
https://leetcode.com/problems/n-queens/description/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
each other. Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the
answer in any order. Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
    1 <= n <= 9

Time Complexity: O(n!)
Space Complexity: O(n * n!)
*/
public class NQueens {

	public static void main(String[] args) {
		int n = 4;
//		int n = 1;
		List<List<String>> result = solveNQueens(n);
		System.out.println(result);
	}

	static public List<List<String>> solveNQueens(int n) {
		Set<Integer> cols = new HashSet<>();
		Set<Integer> posDiagonals = new HashSet<>();
		Set<Integer> negDiagonals = new HashSet<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> result = new ArrayList<>();
		int row = 0;
		backtrack(board, n, row, cols, posDiagonals, negDiagonals, result);
		return result;
	}

	private static void backtrack(char[][] board, int n, int row, Set<Integer> cols, Set<Integer> posDiagonals, Set<Integer> negDiagonals,
			List<List<String>> result) {
		if (row == n) {
			result.add(constructBoard(board));
			return;
		}
		for (int col = 0; col < n; col++) {
			int curPosDiagonal = row + col;
			int curNegDiagonal = row - col;
			if (cols.contains(col) || posDiagonals.contains(curPosDiagonal) || negDiagonals.contains(curNegDiagonal))
				continue;
			board[row][col] = 'Q';
			cols.add(col);
			posDiagonals.add(curPosDiagonal);
			negDiagonals.add(curNegDiagonal);
			backtrack(board, n, row + 1, cols, posDiagonals, negDiagonals, result);

			board[row][col] = '.';
			cols.remove(col);
			posDiagonals.remove(curPosDiagonal);
			negDiagonals.remove(curNegDiagonal);
		}
	}

	private static List<String> constructBoard(char[][] board) {
		List<String> solutions = new ArrayList<>();
		for (char[] rows : board) {
			solutions.add(new String(rows));
		}
		return solutions;
	}
}
