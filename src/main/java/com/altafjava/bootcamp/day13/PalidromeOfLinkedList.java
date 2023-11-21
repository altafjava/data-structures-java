package com.altafjava.bootcamp.day13;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/description/

Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9
 
Follow up: Could you do it in O(n) time and O(1) space?

*/
public class PalidromeOfLinkedList {

	public static void main(String[] args) {
//		ListNode head = ListNodeUtil.createListNode(1, 2, 2, 1);
		ListNode head = ListNodeUtil.createListNode(1, 2);
		boolean palindrome = isPalindrome(head);
		System.out.println(palindrome);
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode revNode = reverse(slow);
		while (revNode != null) {
			if (head.val != revNode.val)
				return false;
			revNode = revNode.next;
			head = head.next;
		}
		return true;
	}

	private static ListNode reverse(ListNode head) {
		ListNode revNode = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = revNode;
			revNode = head;
			head = next;
		}
		return revNode;
	}

}
