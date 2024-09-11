package com.altafjava.patterns.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
110. Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104
*/
public class BalancedBinaryTree {

	public static void main(String[] args) {
		Integer[] root = { 3, 9, 20, null, null, 15, 7 };
//		Integer[] root = { 1, 2, 2, 3, 3, null, null, 4, 4 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		boolean balanced = isBalanced(treeNode);
		System.out.println(balanced);
	}

	static public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	static private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = height(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
