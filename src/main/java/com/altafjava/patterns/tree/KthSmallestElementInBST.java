package com.altafjava.patterns.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the 
values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
    The number of nodes in the tree is n.
    1 <= k <= n <= 104
    0 <= Node.val <= 104

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the
kth smallest frequently, how would you optimize?
*/
public class KthSmallestElementInBST {

	public static void main(String[] args) {
		Integer root[] = { 3, 1, 4, null, 2 }, k = 1;
//		Integer root[] = { 5, 3, 6, 2, 4, null, null, 1 }, k = 3;
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		int kthSmallest = kthSmallest(treeNode, k);
		System.out.println(kthSmallest);
	}

	static public int kthSmallest(TreeNode root, int k) {
		int[] count = { k };
		int[] result = new int[1];
		inOrder(root, count, result);
		return result[0];
	}

	static private void inOrder(TreeNode root, int[] count, int[] result) {
		if (root != null) {
			inOrder(root.left, count, result);
			count[0]--;
			if (count[0] == 0) {
				result[0] = root.val;
				return;
			}
			inOrder(root.right, count, result);
		}
	}
//	static public int kthSmallest(TreeNode root, int k) {
//		Stack<TreeNode> stack = new Stack<>();
//		while (!stack.isEmpty() || root != null) {
//			if (root == null) {
//				root = stack.pop();
//				k--;
//				if (k == 0)
//					return root.val;
//				root = root.right;
//			} else {
//				stack.push(root);
//				root = root.left;
//			}
//		}
//		return -1;
//	}

	

}
