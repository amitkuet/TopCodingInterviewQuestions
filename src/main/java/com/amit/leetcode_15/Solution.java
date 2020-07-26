package com.amit.leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Time complexity is O(n log n + n^2) = O(n^2), because we sorted our data, and
 * then we have loop with n iterations, inside each of them we use 2 pointers
 * approach.
 * 
 * Space complexity is potentially O(n^2), because there can be potentially
 * O(n^2) solutions:
 *
 */
public class Solution {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int num1 = nums[i];
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int num2 = nums[left];
				int num3 = nums[right];
				int sum = num1 + num2 + num3;

				if (sum == 0) {
					List<Integer> temp = Arrays.asList(new Integer[] { num1, num2, num3 });
					res.add(temp);
					while (left < nums.length && nums[left] == num2) {
						left++;
					}
					while (right >= 0 && nums[right] == num3) {
						right--;
					}
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
			while (i < nums.length && num1 == nums[i]) {
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// Output is [[-1, -1, 2], [-1, 0, 1]]
		System.out.println(new Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

}
