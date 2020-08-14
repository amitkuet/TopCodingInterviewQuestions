package com.amit.leetcode_11;

/**
 * 
 * Time complexity : O(n). Single pass. 
 * Space complexity : O(1). Constant space is used.
 *
 */
public class Solution {

	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int maxHeight = 0;

		while (left < right) {
			int h = Math.min(height[left], height[right]) * (right - left);
			maxHeight = Math.max(maxHeight, h);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxHeight;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 })); // Output is 49
	}

}
