package com.altafjava.patterns.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Deque;
import com.altafjava.leetcode.util.TreeNode;

public class MaximumDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Maximum Depth: " + findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Maximum Depth: " + findDepth(root));
	}

	public static int findDepth(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cn = queue.poll();
				if (cn.left != null)
					queue.offer(cn.left);
				if (cn.right != null)
					queue.offer(cn.right);
			}
		}
		return level;
	}

}
