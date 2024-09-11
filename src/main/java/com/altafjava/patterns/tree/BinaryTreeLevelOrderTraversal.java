package com.altafjava.patterns.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
*/
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		Integer[] root = { 3, 9, 20, null, null, 15, 7 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		List<List<Integer>> result = levelOrder(treeNode);
		System.out.println(result);
	}

	static public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode pollNode = queue.poll();
				level.add(pollNode.val);
				if (pollNode.left != null) {
					queue.add(pollNode.left);
				}
				if (pollNode.right != null) {
					queue.add(pollNode.right);
				}
			}
			result.add(level);
		}
		return result;
	}
}
