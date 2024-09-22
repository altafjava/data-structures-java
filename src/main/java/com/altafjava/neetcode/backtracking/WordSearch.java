package com.altafjava.neetcode.backtracking;

/*
79. Word Search
https://leetcode.com/problems/word-search/description/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
	            {'A', 'B', 'C', 'E'},
	            {'S', 'F', 'C', 'S'},
	            {'A', 'D', 'E', 'E'}
	        };
//			String word = "ABCCED";
	        String word = "SEE";
//	        String word = "ABCB";
			boolean exist = exist(board, word);
			System.out.println(exist);
		}

	static public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && exist(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	static private boolean exist(char[][] board, String word, int index, int x, int y) {
		if (index == word.length())
			return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index))
			return false;
		char temp = board[x][y];
		board[x][y] = '#';
		boolean found = exist(board, word, index + 1, x + 1, y) || // down
				exist(board, word, index + 1, x - 1, y) || // up
				exist(board, word, index + 1, x, y + 1) || // right
				exist(board, word, index + 1, x, y - 1); // left
		board[x][y] = temp;
		return found;
	}
}
