package com.altafjava.bootcamp.day14;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
61. Rotate List
https://leetcode.com/problems/rotate-list/description/

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 10^9
*/
public class RotateList {

	public static void main(String[] args) {
		ListNode listNode = ListNodeUtil.createListNode(1, 2, 3, 4, 5);
		int k = 5;

//		ListNode listNode = ListNodeUtil.createListNode(0,1, 2);
//		int k = 4;

//		ListNode listNode = null;
//		int k = 0;

		ListNode result = rotateRight(listNode, k);
		System.out.println(result);
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		ListNode tail = head;
		int length = 1;
		while (tail.next != null) {
			length++;
			tail = tail.next;
		}
		k = k % length;
		if (k == 0)
			return head;
		ListNode cn = head;
		for (int i = 1; i < length - k; i++) {
			cn = cn.next;
		}
		tail.next = head;
		head = cn.next;
		cn.next = null;
		return head;
	}

}
