package com.altafjava.neetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
105. Construct Binary Tree from Preorder and Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and 
inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
*/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
//		int[] preorder = {-1}, inorder = {-1};
//		int[] preorder = { 4, 7, 9, 6, 3, 2, 5, 8, 1 }, inorder = { 7, 6, 9, 3, 4, 5, 8, 2, 1 };
		TreeNode treeNode = buildTree(preorder, inorder);
		TreeNodeUtil.print(treeNode);
	}

	static public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
	}

	static private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorderIndex, int inorderStart, int inorderEnd) {
		if (preorderIndex >= preorder.length || inorderStart > inorderEnd) {
			return null;
		}
		int rootValue = preorder[preorderIndex];
		TreeNode root = new TreeNode(rootValue);
		int inorderIndex = inorderStart;
		while (inorder[inorderIndex] != rootValue) {
			inorderIndex++;
		}
		root.left = buildTreeHelper(preorder, inorder, preorderIndex + 1, inorderStart, inorderIndex - 1);
		root.right = buildTreeHelper(preorder, inorder, preorderIndex + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd);
		return root;
	}
}
