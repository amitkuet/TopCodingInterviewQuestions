package com.amit.leetcode_387;

/**
 * 
 * Time complexity : O(N) since we go through the string of length N two times.
 * Space complexity : O(1)
 *
 */
public class Solution {

	public int firstUniqChar(String s) {
		int[] counts = new int[26];

		for (char ch : s.toCharArray()) {
			counts[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (counts[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().firstUniqChar("leetcode")); // Output is 0
		System.out.println(new Solution().firstUniqChar("loveleetcode")); // Output is 2
	}

}
