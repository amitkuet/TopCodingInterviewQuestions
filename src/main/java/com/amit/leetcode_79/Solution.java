package com.amit.leetcode_79;

public class Solution {

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (isFound(board, word, i, j, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isFound(char[][] board, String word, int row, int col, int pos) {
		if (pos >= word.length())
			return true;
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length)
			return false;

		if (board[row][col] != word.charAt(pos))
			return false;

		char temp = board[row][col];
		board[row][col] = '-';

		boolean res = isFound(board, word, row - 1, col, pos + 1) || isFound(board, word, row + 1, col, pos + 1)
				|| isFound(board, word, row, col - 1, pos + 1) || isFound(board, word, row, col + 1, pos + 1);

		board[row][col] = temp;
		return res;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(new Solution().exist(board, "ABCCED")); // true
		System.out.println(new Solution().exist(board, "SEE")); // true
		System.out.println(new Solution().exist(board, "ABCB")); // false
	}

}
