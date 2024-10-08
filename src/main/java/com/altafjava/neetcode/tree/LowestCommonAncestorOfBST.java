package com.altafjava.neetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
235. Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the BST.
*/
public class LowestCommonAncestorOfBST {

	public static void main(String[] args) {
		Integer[] root = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		TreeNode p2=treeNode.left;//2
		TreeNode q8 = treeNode.right;//8
		TreeNode q4 = p2.right;//4

//		Integer[] root = { 2, 1 };
//		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
//		TreeNode p2 = treeNode;// 2
//		TreeNode q1 = treeNode.left;// 1
		TreeNode lowestCommonAncestor = lowestCommonAncestor(treeNode, p2, q8);
		System.out.println(lowestCommonAncestor);
	}
	
	static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (p.val < root.val && q.val < root.val)
				root = root.left;
			else if (p.val > root.val && q.val > root.val)
				root = root.right;
			else
				return root;
		}
		return null;
	}

//	static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if (p.val < root.val && q.val < root.val)
//			return lowestCommonAncestor(root.left, p, q);
//		else if (p.val > root.val && q.val > root.val)
//			return lowestCommonAncestor(root.right, p, q);
//		else
//			return root;
//	}
}
