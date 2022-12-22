package com.altafjava.patterns.depthfirstsearch;

import com.altafjava.leetcode.util.TreeNode;

/**
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node
 * values of that path equals ‘S’.
 */
public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + hasPath(root, 23));
		System.out.println("Tree has path: " + hasPath(root, 16));
	}

	public static boolean hasPath(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		sum = sum - root.val;
		boolean left = hasPath(root.left, sum);
		boolean right = hasPath(root.right, sum);
		return left || right;
	}
}
