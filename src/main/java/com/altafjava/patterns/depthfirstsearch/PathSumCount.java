package com.altafjava.patterns.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import com.altafjava.leetcode.util.TreeNode;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of
 * each path equals ‘S’.
 */
public class PathSumCount {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree paths with sum: " + findPaths(root, 23));
	}

	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}

	private static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
		if (root == null)
			return;
		currentPath.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			allPaths.add(new ArrayList<>(currentPath));
		} else {
			sum = sum - root.val;
			findPathsRecursive(root.left, sum, currentPath, allPaths);
			findPathsRecursive(root.right, sum, currentPath, allPaths);
		}
		currentPath.remove(currentPath.size() - 1);
	}
}
