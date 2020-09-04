package com.amit.leetcode_141;

import helper.ListNode;

// Time - O(N) where N is the total number of nodes
// Space - O(1)
public class Solution {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
