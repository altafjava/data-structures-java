package com.altafjava.neetcode.hashing;

import java.util.HashSet;
import java.util.Set;

/*
36. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/description/

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the 
following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there
are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.
*/
public class ValidSudoku {
	public static void main(String[] args) {
//		char[][] board = {
//	            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//	            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//	            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//	            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//	            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//	            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//	            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//	            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//	            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//	        };
		char[][] board = {
	            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
	            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
	            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
	            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
	            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
	            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
	            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
	            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	        };

        boolean result = isValidSudoku(board);
        System.out.println( result);
	}

	static public boolean isValidSudoku(char[][] board) {
		HashSet<Character>[] rows = new HashSet[9];
		HashSet<Character>[] cols = new HashSet[9];
		HashSet<Character>[] boxes = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				char num = board[r][c];
				if (num == '.')
					continue;
				int boxIndex = (r / 3) * 3 + (c / 3);
				if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num))
					return false;
				rows[r].add(num);
				cols[c].add(num);
				boxes[boxIndex].add(num);
			}
		}
		return true;
	}
}
