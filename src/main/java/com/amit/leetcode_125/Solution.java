package com.amit.leetcode_125;

public class Solution {

	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (left < right && !isApanumericCharacter(s.charAt(left)))
				left++;
			while (left < right && !isApanumericCharacter(s.charAt(right)))
				right--;
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}

	private boolean isApanumericCharacter(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama")); // true
		System.out.println(new Solution().isPalindrome("race a car")); //false
	}

}
