package com.amit.leetcode_103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import helper.TreeNode;

/**
 * 
 * Time - O(N) && Space - O(N)
 *
 */
public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while (!s1.isEmpty()) {
				TreeNode curr = s1.pop();
				list.add(curr.val);
				if (curr.left != null)
					s2.push(curr.left);
				if (curr.right != null)
					s2.push(curr.right);
			}
			res.add(list);

			list = new ArrayList<>();
			while (!s2.isEmpty()) {
				TreeNode curr = s2.pop();
				list.add(curr.val);
				if (curr.right != null)
					s1.push(curr.right);
				if (curr.left != null)
					s1.push(curr.left);
			}
			if (!list.isEmpty())
				res.add(list);
		}
		return res;

	}

}
