package com.amit.leetcode_242;

public class Solution {

	public boolean isAnagram(String s, String t) {
		if (s.isEmpty() && t.isEmpty()) {
			return true;
		}
		if (s.isEmpty() || t.isEmpty() || s.length() != t.length()) {
			return false;
		}
		int[] chars = new int[26];
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
			chars[t.charAt(i) - 'a']--;
		}

		for (int val : chars) {
			if (val > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isAnagram("anagram", "nagaram")); // Output is true
		System.out.println(new Solution().isAnagram("rat", "car")); // Output is false
	}

}
