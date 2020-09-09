package com.amit.leetcode_152;

/**
 * 
 * Time - O(N) single pass
 * Space - O(1)
 *
 */
public class Solution {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int prevMax = nums[0];
		int prevMin = nums[0];
		int finalMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			int currentMax = Math.max(Math.max(prevMax * num, prevMin * num), num);
			int currentMin = Math.min(Math.min(prevMax * num, prevMin * num), num);
			finalMax = Math.max(finalMax, currentMax);
			prevMax = currentMax;
			prevMin = currentMin;
		}
		return finalMax;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(new Solution().maxProduct(nums)); // Output is 6
	}

}
