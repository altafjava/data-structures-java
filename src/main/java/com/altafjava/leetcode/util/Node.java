package com.altafjava.leetcode.util;

public class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node cn = this;
		while (cn != null) {
			sb.append(cn.val + " ");
			cn = cn.next;
		}
		return sb.toString();
	}
}
