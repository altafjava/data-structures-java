package com.altafjava.patterns.slidingwindow;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces
*/
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "abcabcbb";
//		String s = "bbbbb";
//		String s = "pwwkew";
//		String s = " ";
//		String s = "dvdf";
		int length = lengthOfLongestSubstring(s);
		System.out.println(length);
	}

	static public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int[] hash = new int[128]; // Assuming ASCII characters
		Arrays.fill(hash, -1);
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// Move the start pointer to the right of the last occurrence of currentChar
			if (hash[ch] != -1) {
				start = Math.max(start, hash[ch] + 1);
			}
			// Update the last index of the current character
			hash[ch] = i;
			// Update the maximum length of the substring without repeating characters
			maxLength = Math.max(maxLength, i - start + 1);
		}
		return maxLength;
	}

//	static public int lengthOfLongestSubstring(String s) {
//		int maxLength = 0;
//		int start = 0;
//		Map<Character, Integer> map = new LinkedHashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			if (map.containsKey(ch)) {
//				// Move the start pointer to the right of the last occurrence of currentChar
//				start = Math.max(start, map.get(ch) + 1);
//			}
//			// Update the index of the current character
//			map.put(ch, i);
//			// Update the maximum length of the substring without repeating characters
//			maxLength = Math.max(maxLength, i - start + 1);
//		}
//		return maxLength;
//	}

//	static public int lengthOfLongestSubstring(String s) {
//		int max = 0;
//		Map<Character, Integer> map = new LinkedHashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			if (map.containsKey(ch)) {
//				i = map.get(ch);
//				map.clear();
//			} else {
//				map.put(ch, i);
//			}
//			max = Math.max(max, map.size());
//		}
//		return max;
//	}

	/* This won't work for this input: String s = "dvdf"; */
//	static public int lengthOfLongestSubstring(String s) {
//		int count = 0;
//		StringBuilder sb = new StringBuilder(s.length());
//		for (int i = 0; i < s.length(); i++) {
//			String ch = s.substring(i, i + 1);
//			if (sb.indexOf(ch) == -1) {
//				sb.append(ch);
//			} else {
//				sb = new StringBuilder(ch);
//			}
//			count = Math.max(count, sb.length());
//		}
//		return count;
//	}

}
