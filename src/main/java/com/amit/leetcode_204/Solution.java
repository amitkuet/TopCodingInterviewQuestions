package com.amit.leetcode_204;

import java.util.Arrays;

public class Solution {

	public int countPrimes(int n) {
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);

		for (int i = 2; i * i < n; i++) {
			if (!primes[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				primes[j] = false;
			}
		}

		int ans = 0;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countPrimes(10)); // Output is 4
	}

}
