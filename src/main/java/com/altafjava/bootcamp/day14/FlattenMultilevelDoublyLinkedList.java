package com.altafjava.bootcamp.day14;

import com.altafjava.leetcode.util.Node;

/*
430. Flatten a Multilevel Doubly Linked List
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and
an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also
containing these special nodes. These child lists may have one or more children of their own, and so on, to
produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and
before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation: The multilevel linked list in the input is shown.

Example 2:
Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation: The multilevel linked list in the input is shown.

Example 3:

Input: head = []
Output: []
Explanation: There could be empty list in the input.

Constraints:
    The number of Nodes will not exceed 1000.
    1 <= Node.val <= 105

How the multilevel linked list is represented in test cases:
We use the multilevel linked list from Example 1 above:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

The serialization of each level is as follows:
[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]

To serialize all levels together, we will add nulls in each level to signify no node connects to the upper node of
the previous level. The serialization becomes:
[1,    2,    3, 4, 5, 6, null]
             |
[null, null, 7,    8, 9, 10, null]
                   |
[            null, 11, 12, null]

Merging the serialization of each level and removing trailing nulls we obtain:
[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

Time Complexity: O(N)
Space Complexity: O(N)
*/
public class FlattenMultilevelDoublyLinkedList {

	public static void main(String[] args) {
		Node head = createMultilevelLinkedList();
		Node flattenedHead = flatten(head);
		printDoublyLinkedList(flattenedHead);
	}

	public static Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node current = head;
		while (current != null) {
			if (current.child != null) {
				Node nextNode = current.next;
				Node childHead = flatten(current.child);
				current.next = childHead;
				childHead.prev = current;
				current.child = null;
				while (current.next != null) {
					current = current.next;
				}
				current.next = nextNode;
				if (nextNode != null) {
					nextNode.prev = current;
				}
			}
			current = current.next;
		}
		return head;
	}

	public static void printDoublyLinkedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	public static Node createMultilevelLinkedList() {
		Node head = new Node();
		head.val = 1;

		Node node2 = new Node();
		node2.val = 2;
		head.next = node2;
		node2.prev = head;

		Node node3 = new Node();
		node3.val = 3;
		node2.next = node3;
		node3.prev = node2;

		Node node4 = new Node();
		node4.val = 4;
		node3.next = node4;
		node4.prev = node3;

		Node node5 = new Node();
		node5.val = 5;
		node4.next = node5;
		node5.prev = node4;

		Node node6 = new Node();
		node6.val = 6;
		node5.next = node6;
		node6.prev = node5;

		Node node7 = new Node();
		node7.val = 7;
		node3.child = node7;

		Node node8 = new Node();
		node8.val = 8;
		node7.next = node8;
		node8.prev = node7;

		Node node9 = new Node();
		node9.val = 9;
		node8.next = node9;
		node9.prev = node8;

		Node node10 = new Node();
		node10.val = 10;
		node9.next = node10;
		node10.prev = node9;

		Node node11 = new Node();
		node11.val = 11;
		node8.child = node11;

		Node node12 = new Node();
		node12.val = 12;
		node11.next = node12;
		node12.prev = node11;

		return head;
	}
}
