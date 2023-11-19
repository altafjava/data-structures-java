package com.altafjava.leetcode.util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode cn = this;
		while (cn != null) {
			sb.append(cn.val + " ");
			cn = cn.next;
		}
		return sb.toString();
	}

}