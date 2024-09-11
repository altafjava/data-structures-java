package com.altafjava.patterns.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
572. Subtree of Another Tree
https://leetcode.com/problems/subtree-of-another-tree/description/

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
structure and node values of subRoot and false otherwise. A subtree of a binary tree tree is a tree that consists
of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:
    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 104
    -104 <= subRoot.val <= 104
*/
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		Integer[] root = { 3, 4, 5, 1, 2 }, subRoot = { 4, 1, 2 };
//		Integer[] root = {3,4,5,1,2,null,null,null,null,0}, subRoot = {4,1,2};
		TreeNode rootNode = TreeNodeUtil.createTreeNodeFromArray(root);
		TreeNode subRootNode = TreeNodeUtil.createTreeNodeFromArray(subRoot);
		boolean subtree = isSubtree(rootNode, subRootNode);
		System.out.println(subtree);
	}

	static public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (isSameTree(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	static private boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.val != t2.val)
			return false;
		return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
	}
}
