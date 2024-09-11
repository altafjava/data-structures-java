package com.altafjava.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
every character in t (including duplicates) is included in the window. If there is no such substring, 
return the empty string "". The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:
    m == s.length
    n == t.length
    1 <= m, n <= 105
    s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?
*/
public class MinimumWindowSubstring {

	public static void main(String[] args) {
//		String s = "ADOBECODEBANC", t = "ABC";
//		String s = "a", t = "a";
//		String s = "a", t = "aa";
//		String s = "aa", t = "aa";
		String s = "cabwefgewcwaefgcf", t = "cae";
		String minWindowSubstring = minWindow(s, t);
		System.out.println(minWindowSubstring);
	}

	static public String minWindow(String s, String t) {
		int[] result = { -1, 0, 0 }; // length left right
		int minLength = Integer.MAX_VALUE;
		Map<Character, Integer> needFreq = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			needFreq.put(ch, needFreq.getOrDefault(ch, 0) + 1);
		}
		int need = needFreq.size();
		int have = 0;
		Map<Character, Integer> haveFreq = new HashMap<>();
		int left = 0, right = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			haveFreq.put(ch, haveFreq.getOrDefault(ch, 0) + 1);
			if (needFreq.containsKey(ch) && needFreq.get(ch).equals(haveFreq.get(ch).intValue())) {
				have++;
			}
			while (have == need && left <= right) {
				int substringLength = right - left + 1;
				if (substringLength < minLength) {
					minLength = substringLength;
					result[0] = substringLength;
					result[1] = left;
					result[2] = right;
				}
				char c = s.charAt(left);
				haveFreq.put(c, haveFreq.get(c) - 1);
				if (needFreq.containsKey(c) && haveFreq.get(c) < needFreq.get(c)) {
					have--;
				}
				left++;
			}
			right++;
		}
		return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
	}
}
