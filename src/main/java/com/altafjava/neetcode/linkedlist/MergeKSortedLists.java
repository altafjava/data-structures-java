package com.altafjava.neetcode.linkedlist;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/**
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/description/

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.
*/
public class MergeKSortedLists {

	public static void main(String[] args) {
//		ListNode l1 = ListNodeUtil.createListNode(145);
//		ListNode l2 = ListNodeUtil.createListNode(134);
//		ListNode l3 = ListNodeUtil.createListNode(26);
//		System.out.println(l1 + "  " + l2 + "  " + l3);
//		ListNode result = mergeKLists(new ListNode[] { l1, l2, l3 });
//		System.out.println(result);

//		ListNode l1 = ListNodeUtil.createListNode(589);
//		ListNode l2 = ListNodeUtil.createListNode(17);
//		System.out.println(l1 + "  " + l2);
//		ListNode result = mergeKLists(new ListNode[] { l1, l2 });
//		System.out.println(result);
		
		ListNode result = mergeKLists(new ListNode[] {});
		System.out.println(result);
	}

	static public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		int low = 0, high = lists.length - 1;
		return mergeSort(lists, low, high);
	}

	static private ListNode mergeSort(ListNode[] lists, int low, int high) {
		if (low == high)
			return lists[low];
		int mid = low + (high - low) / 2;
		ListNode listNode1 = mergeSort(lists, low, mid);
		ListNode listNode2 = mergeSort(lists, mid + 1, high);
		return merge2Lists(listNode1, listNode2);
	}

	static private ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode();
		ListNode cn = resultNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cn.next = l1;
				l1 = l1.next;
			} else {
				cn.next = l2;
				l2 = l2.next;
			}
			cn = cn.next;
		}
		while (l1 != null) {
			cn.next = l1;
			cn = cn.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			cn.next = l2;
			cn = cn.next;
			l2 = l2.next;
		}
		return resultNode.next;
	}
}
