package com.altafjava.neetcode.linkedlist;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
*/
public class MergeTwoSortedLists {

	public static void main(String[] args) {
//		ListNode list1 = ListNodeUtil.createListNode(1, 2, 4);
//		ListNode list2 = ListNodeUtil.createListNode(1, 3, 4);
//		ListNode mergedNode = mergeTwoLists(list1, list2);

//		ListNode mergedNode = mergeTwoLists(null, null);

		ListNode list2 = ListNodeUtil.createListNode(0);
		ListNode mergedNode = mergeTwoLists(null, list2);
		System.out.println(mergedNode);
	}

	static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode();
		ListNode cn = head;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cn.next = list1;
				cn = cn.next;
				list1 = list1.next;
			} else {
				cn.next = list2;
				cn = cn.next;
				list2 = list2.next;
			}
		}
		while (list1 != null) {
			cn.next = list1;
			cn = cn.next;
			list1 = list1.next;
		}
		while (list2 != null) {
			cn.next = list2;
			cn = cn.next;
			list2 = list2.next;
		}
		return head.next;
	}

}
