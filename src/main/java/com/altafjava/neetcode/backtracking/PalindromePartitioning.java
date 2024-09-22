package com.altafjava.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import com.altafjava.aop.Omit;
import com.altafjava.aop.Print;

/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/description/

Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
    1 <= s.length <= 16
    s contains only lowercase English letters.
*/
public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> partition = partition(s);
		System.out.println(partition);
	}

	static public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		backtrack(s, 0, current, result);
		return result;
	}

	@Print
	static private void backtrack(@Omit String s, int start, List<String> current, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(current));
		}
		for (int end = start; end < s.length(); end++) {
			String substring = s.substring(start, end + 1);
			if (isPalindrome(s, start, end)) {
				current.add(substring);
				backtrack(s, end + 1, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	static private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}
