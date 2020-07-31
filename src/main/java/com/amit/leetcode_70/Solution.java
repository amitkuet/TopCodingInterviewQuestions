package com.amit.leetcode_70;

/**
 * 
 * Time complexity : O(n). Single loop upto n. 
 * Space complexity : O(n). dp array of size n is used.
 *
 */
public class Solution {

	public int climbStairs(int n) {
		if (n < 2) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(2)); // Output is 2
		System.out.println(new Solution().climbStairs(3)); // Output is 3
	}

}
