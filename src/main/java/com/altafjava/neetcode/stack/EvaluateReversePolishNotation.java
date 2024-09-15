package com.altafjava.neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:
    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:
    1 <= tokens.length <= 104
    tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
*/
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
//		String[] tokens = { "2", "1", "+", "3", "*" };
//		String[] tokens = { "4", "13", "5", "/", "+" };
		String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(tokens));
	}

	static public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String token : tokens) {
			if (isOperator(token)) {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				Integer result = applyOperation(num1, num2, token);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	static private Integer applyOperation(Integer num1, Integer num2, String token) {
		switch (token) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		}
		return null;
	}

	static private boolean isOperator(String token) {
		if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
			return true;
		return false;
	}
}
