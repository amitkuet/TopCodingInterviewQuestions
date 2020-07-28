package com.amit.leetcode_121;

/**
 * 
 * Time complexity : O(n). Only a single pass is needed.
 * 
 * Space complexity : O(1). Only two variables are used.
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
			if (min > prices[i]) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // Output is 5
		System.out.println(new Solution().maxProfit(new int[] { 7, 6, 4, 3, 1 })); // Output is 0
	}

}
