package com.altafjava.leetcode.util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "" + val;
	}
}