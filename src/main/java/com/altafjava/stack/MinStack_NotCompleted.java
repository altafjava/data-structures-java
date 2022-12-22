package com.altafjava.stack;

public class MinStack_NotCompleted {
	private int[] arr;
	private int min;
	private int top = -1;

	public static void main(String[] args) {
		MinStack_NotCompleted minStack = new MinStack_NotCompleted();
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		minStack.push(5);
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		minStack.push(6);
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		minStack.push(3);
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		minStack.push(1);
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		System.out.println("POP: " + minStack.top());
		minStack.pop();
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		System.out.println("POP: " + minStack.top());
		minStack.pop();
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
		System.out.println("POP: " + minStack.top());
		minStack.pop();
		minStack.print();
		System.out.println("TOP: " + minStack.top());
		System.out.println("MIN: " + minStack.getMin());
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; top > -1 && i <= top; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}

	public MinStack_NotCompleted() {
		arr = new int[5];
	}

	public void push(int val) {
		if (top == arr.length - 1) {
			System.err.println("Stack Overflow");
		} else {
			if (top == -1) {
				arr[++top] = val;
				min = val;
			} else {
				if (val >= min)
					arr[++top] = val;
				else {
					arr[++top] = 2 * val - min;
					min = val;
				}
			}
		}
	}

	public void pop() {
		if (top < 0) {
			System.err.println("Stack Underflow");
		} else {
			if (top() < min) {
				min = 2 * min - top();
			}
			arr[top--] = 0;
		}
	}

	public int top() {
		if (top < 0) {
			System.err.println("Stack Underflow");
			return Integer.MIN_VALUE;
		} else {
			if (arr[top] < min) {
				return min;
			}
			return arr[top];
		}
	}

	public int getMin() {
		return min;
	}

}
