package com.amit.leetcode_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			}
			map.put(target - nums[i], i);
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9))); // {0, 1}
	}

}
