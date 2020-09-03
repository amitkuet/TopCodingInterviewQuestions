package com.amit.leetcode_14;

/**
 * 
 * Time complexity : O(S) , where S is the sum of all characters in all strings.
 * In the worst case there will be n equal strings with length m and the
 * algorithm performs S = m*n character comparisons. In the best case there are
 * at most n*minLen comparisons where minLen is the length of the shortest
 * string in the array.
 * 
 * Space complexity : O(1). We only used constant extra space.
 *
 */
public class Solution {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String firstWord = strs[0];

		for (int i = 0; i < firstWord.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || firstWord.charAt(i) != strs[j].charAt(i)) {
					return firstWord.substring(0, i);
				}
			}
		}
		return firstWord;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(new Solution().longestCommonPrefix(strs)); // Output is fl
	}

}
