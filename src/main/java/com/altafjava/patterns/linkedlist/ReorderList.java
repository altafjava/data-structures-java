package com.altafjava.patterns.linkedlist;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/**
143. Reorder List
https://leetcode.com/problems/reorder-list/description/

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000
*/
public class ReorderList {

	public static void main(String[] args) {
//		int[] head = {1,2,3,4};
		int[] head = {1,2,3,4,5};
		ListNode listNode = ListNodeUtil.createListNode(head);
		System.out.println(listNode);
		reorderList(listNode);
		System.out.println(listNode);
	}

	static public void reorderList(ListNode head) {
		ListNode slow = head, fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode prev=null;
		ListNode curr=slow;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		ListNode first=head;
		ListNode second=prev;
		while(second.next!=null) {
			ListNode firstNext=first.next;
			ListNode secondNext=second.next;
			first.next=second;
			second.next=firstNext;
			first=firstNext;
			second=secondNext;
		}
	}
	
}
