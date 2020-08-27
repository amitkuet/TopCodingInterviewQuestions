package com.amit.leetcode_36;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isValidSudokuOptimal(char[][] board) {
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.')
					continue;
				if (!seen.add(board[i][j] + " found in row " + i) || !seen.add(board[i][j] + " found in column " + j)
						|| !seen.add(board[i][j] + " found in box " + i / 3 + ":" + j / 3))
					return false;
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		Set<Character> seen;

		// row check
		for (int i = 0; i < board.length; i++) {
			seen = new HashSet<>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.')
					continue;
				if (!seen.add(board[i][j]))
					return false;
			}
		}

		// column check
		for (int i = 0; i < board.length; i++) {
			seen = new HashSet<>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i] == '.')
					continue;
				if (!seen.add(board[j][i]))
					return false;
			}
		}

		// sub-boxes check
		for (int i = 0; i < board.length; i = i + 3) {
			for (int j = 0; j < board[i].length; j = j + 3) {
				if (!isValidSubBox(board, i, j))
					return false;
			}
		}
		return true;
	}

	private boolean isValidSubBox(char[][] board, int row, int col) {
		Set<Character> seen = new HashSet<>();
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (board[i][j] == '.')
					continue;
				if (!seen.add(board[i][j]))
					return false;
			}
		}
		return true;
	}
}
