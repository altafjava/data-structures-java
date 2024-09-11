package com.altafjava.patterns.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
100. Same Tree
https://leetcode.com/problems/same-tree/description/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104
*/
public class SameTree {

	public static void main(String[] args) {
		Integer[] p = { 1, 2, 3 }, q = { 1, 2, 3 };
//		Integer[] p = {1,2}, q = {1,null,2};
//		Integer[] p = { 1, 2, 1 }, q = { 1, 1, 2 };
//		Integer[] p = { 3, 9, 20, null, null, 5, 7 }, q= { 3, 9, 20, null, null, 15, 17 };

		TreeNode t1 = TreeNodeUtil.createTreeNodeFromArray(p);
		TreeNode t2 = TreeNodeUtil.createTreeNodeFromArray(q);
		boolean sameTree = isSameTree(t1, t2);
		System.out.println(sameTree);
	}

	// Using BFS
	static public boolean isSameTree(TreeNode p, TreeNode q) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(p);
		q2.add(q);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode pollNode1 = q1.poll();
			TreeNode pollNode2 = q2.poll();
			if (pollNode1 == null && pollNode2 == null) {
				continue;
			}
			if (pollNode1 == null || pollNode2 == null)
				return false;
			if (pollNode1.val != pollNode2.val)
				return false;
			q1.add(pollNode1.left);
			q1.add(pollNode1.right);
			q2.add(pollNode2.left);
			q2.add(pollNode2.right);
		}
		return q1.isEmpty() && q2.isEmpty();
	}

	// Using DFS
//	static public boolean isSameTree(TreeNode p, TreeNode q) {
//		if (p == null && q == null)
//			return true;
//		if (p == null || q == null)
//			return false;
//		if (p.val != q.val)
//			return false;
//		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//	}
}
