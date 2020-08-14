package com.amit.leetcode_138;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();

		Node current = head;
		while (current != null) {
			map.put(current, new Node(current.val));
			current = current.next;
		}

		current = head;
		while (current != null) {
			map.get(current).next = map.get(current.next);
			map.get(current).random = map.get(current.random);
			current = current.next;
		}
		return map.get(head);
	}
}
