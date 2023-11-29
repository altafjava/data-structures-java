package com.altafjava.bootcamp.day16;

import java.util.Stack;
import com.altafjava.stack.StackUtil;

/*
You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
We can only use the following functions on this stack.
is_empty(S) : Tests whether stack is empty or not.
push() : Adds a new element to the stack.
pop() : Removes top element from the stack.
peek() : Returns value of the top element. Note that this function does not remove elements from the stack.

Note :
1) Use of any loop constructs like while, for..etc is not allowed.
2) The stack may contain duplicate integers.
3) The stack may contain any integer i.e it may either be negative, positive or zero.
*/
public class SortStackRecursion {

	public static void main(String[] args) {
//		Stack<Integer> stack = StackUtil.createStack(-3,14,18,-5,30);
//		Stack<Integer> stack = StackUtil.createStack(4,3,6,5,1,2);
		Stack<Integer> stack = StackUtil.createStack(2, 1, 5, 6, 3, 4);
		System.out.println("Before: " + stack);
		sortStack(stack);
		System.out.println("After: " + stack);

	}

	private static void sortStack(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sortStack(stack);
			insertSorted(stack, temp);
		}
	}

	private static void insertSorted(Stack<Integer> stack, int value) {
		if (stack.isEmpty() || value > stack.peek()) {
			stack.push(value);
		} else {
			int temp = stack.pop();
			insertSorted(stack, value);
			stack.push(temp);
		}
	}

}
