package com.altafjava.patterns.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import com.altafjava.leetcode.util.TreeNode;

/**
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 * 
 */
public class LevelAverage {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = LevelAverage.findLevelAverages(root);
		System.out.println(result);
	}

	private static List<Double> findLevelAverages(TreeNode root) {
		List<Double> averages = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			double sum = 0;
			for (int i = 0; i < levelSize; i++) {
				TreeNode cn = queue.poll();
				sum += cn.val;
				if (cn.left != null)
					queue.offer(cn.left);
				if (cn.right != null)
					queue.offer(cn.right);
			}
			averages.add(sum / levelSize);
		}
		return averages;
	}

}
