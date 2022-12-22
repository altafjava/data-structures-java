package com.altafjava.leetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

public class IncreasingBST {

	public static void main(String[] args) {
		Integer[] root = { 5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9 };
		TreeNode rootNode = TreeNodeUtil.createTreeNodeFromArray(root);
		IncreasingBST increasingBST = new IncreasingBST();
//		TreeNode outputNode = increasingBST.increasingBST(rootNode);
//		TreeNodeUtil.print(outputNode);
	}

	public void increasingBST(TreeNode root) {
		if (root == null) {
			System.out.println(root);
		} else {
			System.out.println(root.val);
			increasingBST(root.left);
			increasingBST(root.right);
		}
//		return root;
	}
}
