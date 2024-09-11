package com.altafjava.patterns.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
226. Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/description/

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
*/
public class InvertBinaryTree {

	public static void main(String[] args) {
		Integer[] root = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		TreeNode invertTree = invertTree(treeNode);
		System.out.println(invertTree);
	}

	static public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftNode = invertTree(root.left);
		TreeNode rightNode = invertTree(root.right);
		root.left = rightNode;
		root.right = leftNode;
		return root;
	}
}
