package com.altafjava.bootcamp.day13;

import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/*
160. Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null. The test cases are generated such that there
are no cycles anywhere in the entire linked structure. Note that the linked lists must retain their original
structure after the function returns.

Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):
    intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
    listA - The first linked list.
    listB - The second linked list.
    skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
    skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before
the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node
in B) are different node references. In other words, they point to two different locations in memory, while the nodes
with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Example 2:
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the
intersected node in A; There are 1 node before the intersected node in B.

Example 3:
Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not
intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

Constraints:
    The number of nodes of listA is in the m.
    The number of nodes of listB is in the n.
    1 <= m, n <= 3 * 104
    1 <= Node.val <= 105
    0 <= skipA < m
    0 <= skipB < n
    intersectVal is 0 if listA and listB do not intersect.
    intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 
Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
*/
public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
//		ListNode headA = ListNodeUtil.createListNode(41845);
//		ListNode headB = ListNodeUtil.createListNode(561);
//		headB.next.next.next = headA.next.next;

		ListNode headA = ListNodeUtil.createListNode(19124);
		ListNode headB = ListNodeUtil.createListNode(3);
		headB.next = headA.next.next.next;

//		ListNode headA = ListNodeUtil.createListNode(1);
//		ListNode headB = headA;

//		ListNode headA = ListNodeUtil.createListNode(264);
//		ListNode headB = ListNodeUtil.createListNode(15);

		ListNode intersectionNode = getIntersectionNode(headA, headB);
		System.out.println(intersectionNode);
	}

	static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = lengthOfNode(headA);
		int lenB = lengthOfNode(headB);
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenB > lenA) {
			headB = headB.next;
			lenB--;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	static private int lengthOfNode(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

//	static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode tailA = headA;
//		while (tailA.next != null) {
//			tailA = tailA.next;
//		}
//		tailA.next = headB;
//		ListNode intersectionNode = detectCycle(headA);
//		tailA.next = null;
//		return intersectionNode;
//	}
//	static private ListNode detectCycle(ListNode head) {
//		ListNode slow = head, fast = head;
//		while (fast != null && fast.next != null) {
//			slow = slow.next;
//			fast = fast.next.next;
//			if (slow == fast) {
//				slow = head;
//				while (slow != fast) {
//					slow = slow.next;
//					fast = fast.next;
//				}
//				return slow;
//			}
//		}
//		return null;
//	}

}
