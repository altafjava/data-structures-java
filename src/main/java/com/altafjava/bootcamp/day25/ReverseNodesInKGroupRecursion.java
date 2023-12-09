package com.altafjava.bootcamp.day25;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
25. Reverse Nodes in k-Group
https://leetcode.com/problems/reverse-nodes-in-k-group/description/

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
is not a multiple of k then left-out nodes, in the end, should remain as it is. You may not alter the values
in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Example 3:
Input: head = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
Output: [3, 2, 1, 6, 5, 4, 7, 8]

Constraints:
    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000

Follow-up: Can you solve the problem in O(1) extra memory space?
*/
public class ReverseNodesInKGroupRecursion {

	public static void main(String[] args) {
//		ListNode head = ListNodeUtil.createListNode(1, 2, 3, 4, 5);
//		int k = 2;
//		ListNode head = ListNodeUtil.createListNode(1, 2, 3, 4, 5, 6, 7, 8);
//		int k = 3;
		ListNode head = ListNodeUtil.createListNode(1, 2);
		int k = 2;
		ListNode listNode = reverseKGroup(head, k);
		System.out.println(listNode);
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode cn = head;
		int count = 0;
		while (count < k && cn != null) {
			cn = cn.next;
			count++;
		}
		if (count == k) {
			ListNode reverseNode = reverseKGroup(cn, k);
			ListNode node = head;
			while (count > 0) {
				ListNode next = node.next;
				node.next = reverseNode;
				reverseNode = node;
				node = next;
				count--;
			}
			head = reverseNode;
		}
		return head;
	}

}
