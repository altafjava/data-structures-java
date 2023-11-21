package com.altafjava.bootcamp.day13;

import java.util.ArrayDeque;
import java.util.Deque;
import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
445. Add Two Numbers II
https://leetcode.com/problems/add-two-numbers-ii/description/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit
comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:
    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

Follow up: Could you solve it without reversing the input lists?
*/
public class AddTwoNumber2 {

	public static void main(String[] args) {
		ListNode l1 = ListNodeUtil.createListNode(7, 2, 4, 3);
		ListNode l2 = ListNodeUtil.createListNode(5, 6, 4);
		ListNode sum = addTwoNumbers(l1, l2);

//		ListNode l1 = ListNodeUtil.createListNode(2, 4, 3);
//		ListNode l2 = ListNodeUtil.createListNode(5, 6, 4);
//		ListNode sum = addTwoNumbers(l1, l2);

//		ListNode l1 = ListNodeUtil.createListNode(0);
//		ListNode l2 = ListNodeUtil.createListNode(0);
//		ListNode sum = addTwoNumbers(l1, l2);
		System.out.println(sum);
	}

	static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode head = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = carry;
			if (!stack1.isEmpty())
				sum += stack1.pop();
			if (!stack2.isEmpty())
				sum += stack2.pop();
			ListNode cn = new ListNode(sum % 10);
			cn.next = head;
			head = cn;
			carry = sum / 10;
		}
		return head;
	}

}
