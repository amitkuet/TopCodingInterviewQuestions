package com.amit.leetcode_62;

public class Solution {

	public int uniquePathsBottomUp(int m, int n) {
		int[][] paths = new int[m][n];

		// first row
		for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
		}

		// first column
		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[m - 1][n - 1];
	}

	public int uniquePathsTopDown(int m, int n) {
		int[][] memo = new int[m][n];
		return helper(m - 1, n - 1, m, n, memo);
	}

	private int helper(int i, int j, int m, int n, int[][] memo) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		if (i == 0 && j == 0) {
			return 1;
		}
		if (memo[i][j] != 0) {
			return memo[i][j];
		}

		memo[i][j] = helper(i - 1, j, m, n, memo) + helper(i, j - 1, m, n, memo);
		return memo[i][j];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().uniquePathsBottomUp(3, 2)); // Output is 3
		System.out.println(new Solution().uniquePathsBottomUp(7, 3)); // Output is 28

		System.out.println(new Solution().uniquePathsTopDown(3, 2)); // Output is 3
		System.out.println(new Solution().uniquePathsTopDown(7, 3)); // Output is 28
	}

}
