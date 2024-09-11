package com.altafjava.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
567. Permutation in String
https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.
*/
public class PermutationInString {

	public static void main(String[] args) {
//		String s1 = "ab", s2 = "eidbaooo";
		String s1 = "ab", s2 = "a";
//		String s1 = "ab", s2 = "eidboaoo";
		boolean bool = checkInclusion(s1, s2);
		System.out.println(bool);
	}

	static public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		char[] count1 = new char[26];
		char[] count2 = new char[26];
		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
		}
		if (areCountsEqual(count1, count2)) {
			return true;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			count2[s2.charAt(i) - 'a']++;
			count2[s2.charAt(i - s1.length()) - 'a']--;
			if (areCountsEqual(count1, count2)) {
				return true;
			}
		}
		return false;
	}

	static boolean areCountsEqual(char[] count1, char[] count2) {
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] != count2[i])
				return false;
		}
		return true;
	}

//	static public boolean checkInclusion(String s1, String s2) {
//		List<String> result = new ArrayList<>();
//		return backtrack(result, s1, new StringBuilder(), s2);
//	}

	static private boolean backtrack(List<String> result, String s, StringBuilder permutation, String s2) {
		if (permutation.length() == s.length()) {
			if (s2.contains(permutation.toString()))
				return true;
		} else {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (!permutation.toString().contains(String.valueOf(ch))) {
					permutation.append(ch);
					boolean bool = backtrack(result, s, permutation, s2);
					if (bool)
						return true;
					permutation.deleteCharAt(permutation.length() - 1);
				}
			}
		}
		return false;
	}
}
