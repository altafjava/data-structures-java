package com.altafjava.leetcode.tree;

import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

public class MergeBinaryTrees {

	public static void main(String[] args) {
//		Integer[] root1 = { 1, 3, 2, 5 }, root2 = { 2, 1, 3, null, 4, null, 7 };
		Integer[] root1 = { 1 }, root2 = { 1, 2 };
		TreeNode tn1 = TreeNodeUtil.createTreeNodeFromArray(root1);
		TreeNode tn2 = TreeNodeUtil.createTreeNodeFromArray(root2);
		MergeBinaryTrees mergeBinaryTrees = new MergeBinaryTrees();
		TreeNode mergedTree = mergeBinaryTrees.mergeTrees(tn1, tn2);
		TreeNodeUtil.print(mergedTree);
	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null & root2 == null)
			return null;
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;
		TreeNode treeNode = new TreeNode(root1.val + root2.val);
		treeNode.left = mergeTrees(root1.left, root2.left);
		treeNode.right = mergeTrees(root1.right, root2.right);
		return treeNode;
	}

}
