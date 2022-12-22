package com.altafjava.patterns.fastslowpointers;

import com.altafjava.leetcode.util.ListNode;

/*
Given the head of a LinkedList with a cycle, find the length of the cycle
 */
public class CycleLength {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(3, l1);
		ListNode l3 = new ListNode(7, l2);
		ListNode l4 = new ListNode(4, l3);
		ListNode l5 = new ListNode(5, l4);
		ListNode l6 = new ListNode(8, l5);
		l3.next = l6;
		int length = new CycleLength().findCycleLength(l6);
		System.out.println(length);
	}

	private int findCycleLength(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return findLength(slow);
			}
		}
		return 0;
	}

	private int findLength(ListNode slow) {
		ListNode cn = slow;
		int count = 0;
		do {
			count++;
			cn = cn.next;
		} while (cn != slow);
		return count;
	}
}
