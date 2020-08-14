package com.amit.leetcode_217;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Time complexity : O(n). We do search() and insert() for n times and each
 * operation takes constant time.
 * 
 * Space complexity : O(n). The space used by a hash table is linear with the
 * number of elements in it.
 *
 */
public class Solution {

	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			}
			set.add(num);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().containsDuplicate(new int[] { 1, 2, 3, 1 })); // Output is true
		System.out.println(new Solution().containsDuplicate(new int[] { 1, 2, 3, 4 })); // Output is false
	}

}
