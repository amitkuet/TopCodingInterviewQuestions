package com.amit.leetcode_124;

import helper.TreeNode;

public class Solution {

	int maxPathSum;

	public int maxPathSum(TreeNode root) {
		maxPathSum = Integer.MIN_VALUE;
		pathSum(root);
		return maxPathSum;
	}

	private int pathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, pathSum(root.left));
		int right = Math.max(0, pathSum(root.right));

		maxPathSum = Math.max(maxPathSum, left + right + root.val);
		return Math.max(left, right) + root.val;
	}

}
