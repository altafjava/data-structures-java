package com.altafjava.stack;

public class StackUtil {

	public static java.util.Stack<Integer> createStack(int... arr) {
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		return stack;
	}
}
