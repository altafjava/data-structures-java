package com.altafjava.leetcode.util;

public class RandomNode {
	public int val;
	public RandomNode next;
	public RandomNode random;

	public RandomNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return val + " " + next;
	}

}
