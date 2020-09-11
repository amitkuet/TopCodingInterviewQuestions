package com.amit.leetcode_341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Time - O(N) 
 * Space - O(N)
 *
 */
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
	Queue<Integer> queue;

	public NestedIterator(List<NestedInteger> nestedList) {
		queue = new LinkedList<>();
		addAll(nestedList);
	}

	private void addAll(List<NestedInteger> nestedList) {
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				queue.offer(ni.getInteger());
			} else {
				addAll(ni.getList());
			}
		}
	}

	@Override
	public Integer next() {
		return (!queue.isEmpty()) ? queue.poll() : -1;
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}
}