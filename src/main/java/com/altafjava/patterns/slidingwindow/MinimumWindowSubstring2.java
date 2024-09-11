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
public class MinimumWindowSubstring2 {

	public static void main(String[] args) {
//		String s = "ADOBECODEBANC", t = "ABC";
//		String s = "a", t = "a";
//		String s = "a", t = "aa";
		String s = "aa", t = "aa";
		String minWindowSubstring = minWindow(s, t);
		System.out.println(minWindowSubstring);
	}

	static public String minWindow(String s, String t) {
		// Step 1: Create a frequency map for string t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window over string s
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int required = tFreq.size();
        int formed = 0;
        int[] result = {-1, 0, 0};  // minLength, left, right

        while (right < s.length()) {
            // Add one character from the right side of the window
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if the frequency of current character is in t
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Step 3: Contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result[0] = minLength;
                    result[1] = left;
                    result[2] = right;
                }

                // Remove characters from the left side of the window
                windowFreq.put(c, windowFreq.get(c) - 1);
                if (tFreq.containsKey(c) && windowFreq.get(c).intValue() < tFreq.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        // Step 4: Return the minimum window
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
	}
}
