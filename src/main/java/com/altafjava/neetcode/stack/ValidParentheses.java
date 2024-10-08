package com.altafjava.neetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input 
string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
*/
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()";
//		String s = "()[]{}";
//		String s = "(]";
//		String s = "([])";
		boolean valid = isValid(s);
		System.out.println(valid);
	}

	static public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
