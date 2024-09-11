package com.altafjava.patterns.slidingwindow;

import java.util.LinkedHashMap;
import java.util.Map;

/*
424. Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/description/

You are given a string s and an integer k. You can choose any character of the string and change it to any other
uppercase English character. You can perform this operation at most k times. Return the length of the longest
substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

Constraints:
    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
*/
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "AABABBA"; int k = 1;
//		String s = "ABAA"; int k = 0;
//		String s = "ABAB"; int k = 2;
//		String s = "AABABBA"; int k = 1;
		int result = characterReplacement(s, k);
		System.out.println(result);
	}

	static public int characterReplacement(String s, int k) {
		int maxCount = 0;
		int left = 0;
		int result = 0;
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int right = 0; right < s.length(); right++) {
			char rightChar = s.charAt(right);
			map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
			maxCount = Math.max(maxCount, map.get(rightChar));

			int windowSize = right - left + 1;
			if ((windowSize - maxCount) <= k) {
				result = Math.max(result, windowSize);
			} else {
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				left++;
			}
		}
		return result;
	}

}
