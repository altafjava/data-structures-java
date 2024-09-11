package com.altafjava.patterns.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.altafjava.leetcode.util.TreeNode;
import com.altafjava.leetcode.util.TreeNodeUtil;

/**
297. Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later 
in the same or another computer environment. 
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be 
serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily
need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -1000 <= Node.val <= 1000
*/
public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
//		Integer[] root = { 1, 2, 3, null, null, 4, 5 };
//		Integer[] root = {};
		Integer[] root = { 1, 2, 3, null, null, 4, 5, 6, 7 };
		TreeNode treeNode = TreeNodeUtil.createTreeNodeFromArray(root);
		String serialize = serialize(treeNode);
		System.out.println(serialize);
		TreeNode deserialize = deserialize(serialize);
		TreeNodeUtil.print(deserialize);
	}

	static public String serialize(TreeNode root) {
		if (root == null)
			return "null";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode pollNode = q.poll();
			if (pollNode == null)
				sb.append("null,");
			else {
				sb.append(pollNode.val).append(",");
				q.add(pollNode.left);
				q.add(pollNode.right);
			}
		}
		return sb.substring(0, sb.length() - 1);
	}

	static public TreeNode deserialize(String data) {
		if (data == null || data.equals("null"))
			return null;
		String[] splits = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int index = 1;
		while (!q.isEmpty() && index < splits.length) {
			TreeNode pollNode = q.poll();
			String s = splits[index];
			if (!s.equals("null")) {
				pollNode.left = new TreeNode(Integer.parseInt(s));
				q.add(pollNode.left);
			}
			index++;
			s = splits[index];
			if (index < splits.length && !s.equals("null")) {
				pollNode.right = new TreeNode(Integer.parseInt(s));
				q.add(pollNode.right);
			}
			index++;
		}
		return root;
	}
}
