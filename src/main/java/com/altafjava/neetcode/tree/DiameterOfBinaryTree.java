package com.altafjava.neetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
543. Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/description/

Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may 
not pass through the root. The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1

Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100
*/
public class DiameterOfBinaryTree {

	static int maxDiameter = 0;

	public static void main(String[] args) {
		Integer[] root = { 1, 2, 3, 4, 5 };
//		Integer[] root = {1,2};
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		int diameterOfBinaryTree = diameterOfBinaryTree(treeNode);
		System.out.println(diameterOfBinaryTree);
	}

	static public int diameterOfBinaryTree(TreeNode root) {
		calculateDepth(root);
		return maxDiameter;
	}

	static public int calculateDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = calculateDepth(root.left);
		int right = calculateDepth(root.right);
		maxDiameter = Math.max(maxDiameter, left + right);
		return Math.max(left, right) + 1;
	}
}
