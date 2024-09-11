package com.altafjava.patterns.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
104. Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the 
farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
*/
public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		Integer[] root = { 3, 9, 20, null, null, 15, 7 };
//		Integer[] root = { 1, null, 2 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		int maxDepth = maxDepth(treeNode);
		System.out.println(maxDepth);
	}
	// BFS
	static public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				TreeNode pollNode = q.poll();
				if (pollNode.left != null)
					q.add(pollNode.left);
				if (pollNode.right != null)
					q.add(pollNode.right);
			}
		}
		return level;
	}
	// DFS
//	static public int maxDepth(TreeNode root) {
//		if (root == null)
//			return 0;
//		if (root.left == null && root.right == null)
//			return 1;
//		int leftMax = maxDepth(root.left);
//		int rightMax = maxDepth(root.right);
//		return 1 + Math.max(leftMax, rightMax);
//	}
}
