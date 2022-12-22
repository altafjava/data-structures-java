package com.altafjava.leetcode.linkedlist.medium;

import java.util.LinkedHashMap;
import java.util.Map;
import com.altafjava.leetcode.util.RandomNode;

public class CloneLinkedList {

	public static void main(String[] args) {
		RandomNode seven = new RandomNode(7);
		RandomNode thirteen = new RandomNode(13);
		RandomNode eleven = new RandomNode(11);
		RandomNode ten = new RandomNode(10);
		RandomNode one = new RandomNode(1);
		seven.next = thirteen;
		seven.random = one;
		thirteen.next = eleven;
		thirteen.random = seven;
		eleven.next = ten;
		eleven.random = one;
		ten.next = one;
		ten.random = eleven;
		one.random = seven;
		CloneLinkedList test = new CloneLinkedList();
		System.out.println(seven);
		RandomNode clonedNode = test.copyRandomList(seven);
		System.out.println(clonedNode);
	}

	public RandomNode copyRandomList(RandomNode head) {
		if (head == null)
			return head;
		Map<RandomNode, RandomNode> map = new LinkedHashMap<>();
		RandomNode temp = head;
		while (temp != null) {
			map.put(temp, new RandomNode(temp.val));
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			RandomNode node = map.get(temp);
			node.next = map.get(temp.next);
			node.random = map.get(temp.random);
			temp = temp.next;
		}
		return map.get(head);
	}

}
