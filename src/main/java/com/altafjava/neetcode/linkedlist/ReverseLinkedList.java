package com.altafjava.neetcode.linkedlist;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/description/

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
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode listNode = ListNodeUtil.createListNode(12345);
		ListNodeUtil.print(listNode);
		ListNode reversedListNode = reverseList(listNode);
		ListNodeUtil.print(reversedListNode);
	}

	static public ListNode reverseList(ListNode head) {
		ListNode reverseNode = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = reverseNode;
			reverseNode = head;
			head = next;
		}
		return reverseNode;
	}
	
//	static public ListNode reverseList(ListNode head) {
//		return reverse(head, null);
//	}

//	static private ListNode reverse(ListNode head, ListNode reverseHead) {
//		if (head == null)
//			return reverseHead;
//		ListNode next = head.next;
//		head.next = reverseHead;
//		return reverse(next, head);
//	}

}
