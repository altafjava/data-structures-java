package com.altafjava.patterns.breadthfirstsearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, connect each node with its level order successor. The last node of each level should point to a
 * null node.
 */
public class ConnectLevelOrderSiblings {

	public static void main(String[] args) {
		TreeNodeWithNext root = new TreeNodeWithNext(12);
		root.left = new TreeNodeWithNext(7);
		root.right = new TreeNodeWithNext(1);
		root.left.left = new TreeNodeWithNext(9);
		root.right.left = new TreeNodeWithNext(10);
		root.right.right = new TreeNodeWithNext(5);
		ConnectLevelOrderSiblings.connect(root);
		System.out.println("Level order traversal using 'next' pointer: ");
		root.printLevelOrder();
	}

	public static void connect(TreeNodeWithNext root) {
		Deque<TreeNodeWithNext> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNodeWithNext prev = null;
			for (int i = 0; i < size; i++) {
				TreeNodeWithNext cn = queue.poll();
				if (prev != null)
					prev.next = cn;
				if (cn.left != null)
					queue.offer(cn.left);
				if (cn.right != null)
					queue.offer(cn.right);
				prev = cn;
			}
		}
	}
}
