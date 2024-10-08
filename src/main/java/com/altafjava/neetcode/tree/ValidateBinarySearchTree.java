package com.altafjava.neetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/description/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1
*/
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
//		Integer[] root = {2,1,3};
//		Integer[] root = {5,1,4,null,null,3,6};
//		Integer[] root = { 5, 3, 7, null, null, 4, 8 };
		Integer[] root = { 2147483647 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		boolean validBST = isValidBST(treeNode);
		System.out.println(validBST);
	}

	static public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	static private boolean isValid(TreeNode node, Integer min, Integer max) {
		if (node == null)
			return true;
		if ((max != null && node.val >= max) || (min != null && node.val <= min))
			return false;
		return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	}
}
