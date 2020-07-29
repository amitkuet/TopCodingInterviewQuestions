package com.amit.leetcode_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.TreeNode;

/**
 * 
 * Time - O(N) Space - O(N)
 *
 */
public class Solution {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode left = root;

		while (!stack.isEmpty() || left != null) {
			while (left != null) {
				stack.push(left);
				left = left.left;
			}

			TreeNode temp = stack.pop();
			res.add(temp.val);
			left = temp.right;
		}

		return res;
	}
}
