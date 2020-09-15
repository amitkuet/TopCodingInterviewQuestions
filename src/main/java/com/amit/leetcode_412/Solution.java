package com.amit.leetcode_412;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Time Complexity : O(N) 
 * Space Complexity : O(1)
 *
 */
public class Solution {

	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0 && i % 3 == 0) {
				result.add("FizzBuzz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}
}
