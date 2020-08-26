package com.amit.leetcode_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public boolean isValid(String s) {
		if (s == null || s.isEmpty())
			return true;
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				char popChar = (stack.isEmpty()) ? '#' : stack.pop();
				if (popChar != map.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isValid("()")); // true
		System.out.println(new Solution().isValid("()[]{}")); // true
		System.out.println(new Solution().isValid("(]")); // false
		System.out.println(new Solution().isValid("([)]")); // false
		System.out.println(new Solution().isValid("{[]}")); // true
	}

}
