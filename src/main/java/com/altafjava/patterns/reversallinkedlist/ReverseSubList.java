package com.altafjava.patterns.reversallinkedlist;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
Given the head of a LinkedList and two positions �p� and �q�, reverse the LinkedList from position �p� to �q�.
 Input: 1 2 3 4 5, p=2, q=4
 
 Output: 1 4 3 2 5 
 
 */
public class ReverseSubList {

	public static void main(String[] args) {
		ListNode listNode = ListNodeUtil.createListNode(12345);
		int p = 2, q = 4;
		ListNodeUtil.print(listNode);
		ListNode reversed = new ReverseSubList().reverse(listNode, p, q);
		ListNodeUtil.print(reversed);
	}

	public ListNode reverse(ListNode head, int p, int q) {
		if (p == q)
			return head;
		ListNode prev = null, cn = head;
		for (int i = 0; cn != null && i < p - 1; i++) {
			prev = cn;
			cn = cn.next;
		}
		ListNode lastNodeFirstPart = prev, lastNodeSublist = cn, next = null;
		prev = null;
		for (int i = 0; cn != null && i <= (q - p); i++) {
			next = cn.next;
			cn.next = prev;
			prev = cn;
			cn = next;
		}
		lastNodeFirstPart.next = prev;
		lastNodeSublist.next = cn;
		return head;
	}

}
