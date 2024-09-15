package com.altafjava.neetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/description/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
    1 <= n <= 8
*/
public class GenerateParentheses {

	public static void main(String[] args) {
//		int n = 3;
		int n = 2;
		List<String> parenthesis = generateParenthesis(n);
		System.out.println(parenthesis);
	}

	static public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		String current = "";
		generate(result, current, 0, 0, n);
		return result;
	}

	static private void generate(List<String> result, String current, int open, int close, int n) {
		if (current.length() == 2 * n && open == close) {
			result.add(current);
			return;
		}
		if (open < n) {
			generate(result, current + "(", open + 1, close, n);
		}
		if (close < open) {
			generate(result, current + ")", open, close + 1, n);
		}
	}
}
