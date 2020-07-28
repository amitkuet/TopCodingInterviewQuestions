package com.amit.leetcode_122;

/**
 * 
 * Time complexity : O(n). Single pass.
 * 
 * Space complexity: O(1). Constant space needed.
 *
 */
public class Solution {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int max = 0;
		int min = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min) {
				max += prices[i] - min;
			}
			min = prices[i];
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output is 7
		System.out.println(new Solution().maxProfit(new int[] { 1, 2, 3, 4, 5 })); // Output is 4
	}

}
