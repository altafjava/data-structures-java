package com.altafjava.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;

public class Tree {

	private static TreeNode root;

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.print();
		tree.add(10);
		tree.print();
		tree.add(5);
		tree.print();
		tree.add(15);
		tree.print();
		tree.add(2);
		tree.print();
		tree.add(18);
		tree.print();
		tree.add(12);
		tree.print();
		tree.add(8);
		tree.print();
		tree.iteratePreorder(root);
		tree.iterateInorder(root);
		tree.iteratePostorder(root);
		tree.levelOrderTraversal();
	}

	public int height(TreeNode node) {
		return 0;
	}

	public void add(int num) {
		if (root == null) {
			root = new TreeNode(num);
		} else {
			insert(root, num);
		}
	}

	public void insert(TreeNode node, int num) {
		if (num < node.val) {
			if (node.left != null) {
				insert(node.left, num);
			} else {
				node.left = new TreeNode(num);
			}
		} else {
			if (node.right != null) {
				insert(node.right, num);
			} else {
				node.right = new TreeNode(num);
			}
		}
	}

	public void print() {
		System.out.print("[");
		preorder(root);
//		inorder(root);
//		postorder(root);
		System.out.println("]");
	}

	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new ArrayDeque<>();
		System.out.print("[");
		if (root != null) {
			System.out.print(root.val + " ");
			queue.offer(root);
		}
		TreeNode cn = null;
		while (!queue.isEmpty()) {
			cn = queue.poll();
			if (cn.left != null) {
				System.out.print(cn.left.val + " ");
				queue.offer(cn.left);
			}
			if (cn.right != null) {
				System.out.print(cn.right.val + " ");
				queue.offer(cn.right);
			}
		}
		System.out.println("]");
	}

	public void iteratePreorder(TreeNode node) {
		System.out.print("{");
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
				node = node.right;
			} else {
				System.out.print(node.val + " ");
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println("}");
	}

	public void iterateInorder(TreeNode node) {
		System.out.print("{");
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.val + " ");
				node = node.right;
			} else {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println("}");
	}

	public void iteratePostorder(TreeNode node) {
		System.out.print("{");
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
		System.out.println("}");
	}

	public void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.val + " ");
			inorder(node.right);
		}
	}

	public void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.val + " ");
		}
	}

}
