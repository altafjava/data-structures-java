package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could 
represent. Return the answer in any order. A mapping of digits to letters (just like on the telephone buttons)
is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
*/
public class LetterCombinationsOfPhoneNumber {

	private static final Map<Character, String> map = new HashMap<>();

	static {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}

	public static void main(String[] args) {
//		String digits = "23";
		String digits = "";
//		String digits = "2";
		List<String> letterCombinations = letterCombinations(digits);
		System.out.println(letterCombinations);
	}

	static public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		StringBuilder current = new StringBuilder();
		backtrack(digits, 0, result, current);
		return result;
	}

	static private void backtrack(String digits, int index, List<String> result, StringBuilder current) {
		if (current.length() == digits.length()) {
			result.add(current.toString());
			return;
		}
		String string = map.get(digits.charAt(index));
		for (int i = 0; i < string.length(); i++) {
			current.append(string.charAt(i));
			backtrack(digits, index + 1, result, current);
			current.deleteCharAt(current.length() - 1);
		}
	}
}
