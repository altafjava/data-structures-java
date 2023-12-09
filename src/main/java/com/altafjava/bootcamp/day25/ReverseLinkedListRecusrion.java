package com.altafjava.bootcamp.day25;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedListRecusrion {

	public static void main(String[] args) {
		ListNode listNode = ListNodeUtil.createListNode(12345);
		ListNodeUtil.print(listNode);
		ListNode reversedListNode = reverseList(listNode);
		ListNodeUtil.print(reversedListNode);
	}

	public static ListNode reverseList(ListNode head) {
		return reverseList(head, null);
	}

	private static ListNode reverseList(ListNode head, ListNode reverseHead) {
		if (head == null)
			return reverseHead;
		ListNode next = head.next;
		head.next = reverseHead;
		return reverseList(next, head);
	}

}
