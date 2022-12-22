package com.altafjava.patterns.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import com.altafjava.leetcode.util.TreeNode;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest
 * level comes first. You should populate the values of all nodes in each level from left to right in separate
 * sub-arrays.
 */
public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		System.out.println(result);
	}

	/**
	 * The time complexity of this algorithm is O(N), where ‘N’ is the total number of nodes in the tree. This is due to the
	 * fact that we traverse each node once.</br>
	 * The space complexity of this algorithm will be O(N) as we need to return a list containing the level order traversal.
	 * We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen
	 * only at the lowest level), therefore we will need O(N) space to store them in the queue.
	 * 
	 * @param
	 * @return List
	 */
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode cn = queue.poll();

				currentLevel.add(cn.val);
				if (cn.left != null) {
					queue.offer(cn.left);
				}
				if (cn.right != null) {
					queue.offer(cn.right);
				}
			}
			result.add(0, currentLevel);
		}
		return result;
	}

}
