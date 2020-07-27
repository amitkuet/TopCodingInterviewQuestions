package com.amit.leetcode_2;

import helper.ListNode;
import helper.MyLinkedList;

/**
 * 
 * Time complexity : O(max(m,n)). Assume that m and n represents the length of
 * l1 and l2 respectively, the algorithm iterates at most max(m, n) times.
 * 
 * Space complexity : O(max(m,n)). The length of the new list is at most
 * max(m,n) + 1.
 *
 */
public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = (l1 == null) ? 0 : l1.val;
			int val2 = (l2 == null) ? 0 : l2.val;
			int sum = val1 + val2 + carry;
			current.next = new ListNode(sum % 10);
			current = current.next;
			carry = sum / 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = MyLinkedList.generateLinkedList(new int[] { 2, 4, 3 });
		ListNode l2 = MyLinkedList.generateLinkedList(new int[] { 5, 6, 4 });
		ListNode res = new Solution().addTwoNumbers(l1, l2);
		MyLinkedList.printLinkedList(res);
	}

}
