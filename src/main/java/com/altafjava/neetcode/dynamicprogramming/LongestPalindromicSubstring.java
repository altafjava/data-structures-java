package com.altafjava.neetcode.dynamicprogramming;

/**
5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters.
*/
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
//		String s = "babad";
		String s = "cbbd";
		String longestPalindrome = longestPalindrome(s);
		System.out.println(longestPalindrome);
	}

	static public String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int length1 = expandAroundCenter(s, i, i);// for odd length palidromes
			int length2 = expandAroundCenter(s, i, i + 1);// for even length palidromes
			int length = Math.max(length1, length2);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = i + (length / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	// checkPalindrome(String s, int left, int right)
	static private int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1; // Return the length of the palindrome
	}
}
