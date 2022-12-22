package com.altafjava.leetcode.util;

public class TreeNodeUtil {

	public static void main(String[] args) {
		Integer[] tree = { 7, 4, 3, null, null, 6, 19 };
//		Integer[] tree = { 8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1 };
		TreeNode head = new TreeNode(tree[0]);
		createTree(head, 0, tree);
	}

	public static TreeNode createTreeNodeFromArray(Integer[] arr) {
		TreeNode head = new TreeNode(arr[0]);
		createTree(head, 0, arr);
		return head;
	}

	private static TreeNode createTree(TreeNode node, int i, Integer[] arr) {
		int leftIndex = 2 * i + 1;
		if (leftIndex < arr.length) {
			if (arr[leftIndex] == null) {
				node.left = null;
			} else {
				node.left = new TreeNode(arr[leftIndex]);
				createTree(node.left, leftIndex, arr);
			}
		}
		int rightIndex = 2 * i + 2;
		if (rightIndex < arr.length) {
			if (arr[rightIndex] == null) {
				node.right = null;
			} else {
				node.right = new TreeNode(arr[rightIndex]);
				createTree(node.right, rightIndex, arr);
			}
		}
		return node;
	}

	public static void print(TreeNode node) {
		System.out.print("[");
		preorder(node);
		System.out.println("]");
	}

	public static void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.val + " ");
			inorder(node.right);
		}
	}

	public static void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.val + " ");
		}
	}
}
