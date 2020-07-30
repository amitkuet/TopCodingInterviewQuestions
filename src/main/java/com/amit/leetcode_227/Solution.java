package com.amit.leetcode_227;

/**
 * 
 * Time - O(N) where N is the length of the String and Space - O(1)
 *
 */
public class Solution {

	public int calculate(String s) {
		int md = -1;
		int sign = 1;
		int prev = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}
				i--;

				if (md == 0) {
					prev = prev * num;
					md = -1;
				} else if (md == 1) {
					prev = prev / num;
					md = -1;
				} else {
					prev = num;
				}
			} else if (s.charAt(i) == '+') {
				result = result + sign * prev;
				sign = 1;
			} else if (s.charAt(i) == '-') {
				result = result + sign * prev;
				sign = -1;
			} else if (s.charAt(i) == '*') {
				md = 0;
			} else if (s.charAt(i) == '/') {
				md = 1;
			}
		}

		result = result + sign * prev;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().calculate("3+2*2")); // Output is 7
		System.out.println(new Solution().calculate("3+5/2")); // Output is 5
	}

}
