package com.altafjava.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import com.altafjava.leetcode.util.TreeNode;

public class Test {

	static TreeNode head = null;

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(10, 5, 15, 2, 18, 12, 8);
		for (int i : integers) {
			insert(head, i);
		}
//		preOrder(head);
//		iteratePreOrder(head);
//		iterateInOrder(head);
//		iteratePostOrder(head);
		levelOrderTraversal(head);

	}

	private static void levelOrderTraversal(TreeNode node) {
		System.out.println();
		Deque<TreeNode> queue = new ArrayDeque<>();
		if (node != null) {
			System.out.print(node.val + " ");
			queue.offer(node);
		}
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.left != null) {
				System.out.print(node.left.val + " ");
				queue.offer(node.left);
			}
			if (node.right != null) {
				System.out.print(node.right.val + " ");
				queue.offer(node.right);
			}
		}
	}

	private static void iteratePostOrder(TreeNode node) {
		System.out.println();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				if (node.val > 0) {
					node.val = -node.val;
					stack.push(node);
					node = node.right;
				} else {
					node.val = -node.val;
					System.out.print(node.val + " ");
					node = null;
				}
			}
		}
	}

	private static void iterateInOrder(TreeNode node) {
		System.out.println();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}
	}

	public static void preOrder(TreeNode node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.print(node.val + " ");
		}
	}

	public static void iteratePreOrder(TreeNode node) {
		System.out.println();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				System.out.print(node.val + " ");
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	private static void insert(TreeNode node, int num) {
		if (node == null) {
			head = new TreeNode(num);
		} else {
			if (num < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(num);
				} else {
					insert(node.left, num);
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(num);
				} else {
					insert(node.right, num);
				}
			}
		}
	}

}
