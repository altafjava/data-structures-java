package com.altafjava.neetcode.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
49. Group Anagrams
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
*/
public class GroupAnagrams {

	public static void main(String[] args) {
//		String[] strs = {"eat","tea","tan","ate","nat","bat"};
//		String[] strs = {""};
		String[] strs = { "a" };
		List<List<String>> result = groupAnagrams(strs);
		System.out.println(result);
	}

	static public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);
			map.putIfAbsent(sortedString, new ArrayList<>());
			map.get(sortedString).add(s);
		}
		return new ArrayList<>(map.values());
	}
}
