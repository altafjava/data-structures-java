package com.altafjava.patterns.kwaymerge;

import java.util.PriorityQueue;
import com.altafjava.leetcode.util.ListNode;
import com.altafjava.leetcode.util.ListNodeUtil;

/**
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.</br>
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]</br>
 * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]</br>
 * </br>
 * Input: L1=[5, 8, 9], L2=[1, 7]</br>
 * Output: [1, 5, 7, 8, 9]</br>
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
//		ListNode l1 = ListNodeUtil.createListNode(268);
//		ListNode l2 = ListNodeUtil.createListNode(367);
//		ListNode l3 = ListNodeUtil.createListNode(134);
//		ListNode result = merge(new ListNode[] { l1, l2, l3 });
//		ListNodeUtil.print(result);
		ListNode l1 = ListNodeUtil.createListNode(589);
		ListNode l2 = ListNodeUtil.createListNode(17);
		ListNode result = merge(new ListNode[] { l1, l2 });
		ListNodeUtil.print(result);

	}

	/**
	 * <b>Time Complexity: </b>Since we’ll be going through all the elements of all arrays and will be removing/adding one
	 * element to the heap in each step, the time complexity of the above algorithm will be O(N*logK), where ‘N’ is the
	 * total number of elements in all the ‘K’ input arrays.</br>
	 * <b>Space Complexity: </b>The space complexity will be O(K) because, at any time, our min-heap will be storing one
	 * number from all the ‘K’ input arrays.</br>
	 * 
	 * @param lists
	 * @return
	 */
	private static ListNode merge(ListNode[] lists) {
		ListNode resultNode = new ListNode();
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode ln : lists) {
			if (ln != null)
				minHeap.add(ln);
		}
		ListNode cn = resultNode;
		while (!minHeap.isEmpty()) {
			ListNode oldNode = minHeap.poll();
			cn.next = oldNode;
			cn = cn.next;
			if (oldNode.next != null)
				minHeap.add(oldNode.next);
		}
		return resultNode.next;
	}

}
