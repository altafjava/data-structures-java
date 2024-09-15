package com.altafjava.neetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/description/

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
*/
public class BinaryTreeRightSideView {

	public static void main(String[] args) {
//		Integer[] root = { 1, 2, 3, null, 5, null, 4 };
//		Integer[] root = { 1, null, 3 };
		Integer[] root = { };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		List<Integer> rightSideView = rightSideView(treeNode);
		System.out.println(rightSideView);
	}

	static public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 1; i <= size; i++) {
				TreeNode pollNode = q.poll();
				if (i == size) {
					result.add(pollNode.val);
				}
				if (pollNode.left != null)
					q.add(pollNode.left);
				if (pollNode.right != null)
					q.add(pollNode.right);
			}
		}
		return result;
	}
}
