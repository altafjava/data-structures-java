package com.altafjava.bootcamp.day21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
You have been given a queue of ‘N’ distinct integers. For a given queue, you need to reverse all the elements in it.
Note: You need to reverse the string in O(N) time complexity.

Constraints:
1 <= T <= 50
1 <= N <= 10^4
0 <= Q[i] <= 10^5
*/
public class ReverseQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		System.out.println("Before: " + queue);
		reverse(queue);
		System.out.println("After: " + queue);
	}

	public static void reverse(Queue<Integer> q) {
		Stack<Integer> stack = new Stack<>();
		while (!q.isEmpty()) {
			stack.push(q.poll());
		}
		while (!stack.isEmpty()) {
			q.offer(stack.pop());
		}
	}

}
