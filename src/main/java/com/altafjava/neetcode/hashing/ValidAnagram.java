package com.altafjava.neetcode.hashing;

/**
242. Valid Anagram
https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/
public class ValidAnagram {

	public static void main(String[] args) {
		String s1 = "anagram", s2 = "nagaram";
//		String s1 = "rat", s2 = "car";
		boolean anagram = isAnagram(s1, s2);
		System.out.println(anagram);
	}

	static public boolean isAnagram(String s, String t) {
		char[] freq = new char[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			freq[c - 'a']--;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0)
				return false;
		}
		return true;
	}
}
