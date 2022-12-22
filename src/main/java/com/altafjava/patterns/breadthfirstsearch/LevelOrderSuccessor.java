package com.altafjava.patterns.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Deque;
import com.altafjava.leetcode.util.TreeNode;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree. The level order
 * successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result + " ");
		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}

	public static TreeNode findSuccessor(TreeNode root, int key) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cn = queue.poll();
			if (cn.left != null)
				queue.offer(cn.left);
			if (cn.right != null)
				queue.offer(cn.right);
			if (cn.val == key)
				break;
		}
		return queue.peek();
	}
}
