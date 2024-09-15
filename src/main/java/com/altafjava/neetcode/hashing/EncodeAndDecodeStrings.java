package com.altafjava.neetcode.hashing;

import java.util.ArrayList;
import java.util.List;

/**
659 · Encode and Decode Strings
https://www.lintcode.com/problem/659/description

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
and is decoded back to the original list of strings. Please implement encode and decode

Note: Because the string may contain any of the 256 legal ASCII characters, your algorithm must be able to
handle any character that may appear. Do not rely on any libraries, the purpose of this problem is to 
implement the "encode" and "decode" algorithms on your own.


Example1
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"

Example2
Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
*/
public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		List<String> input = List.of("lint", "code", "love", "you");
//		List<String> input = List.of("we", "say", ":", "yes");
		System.out.println(input);
		String encoded = encode(input);
		System.out.println(encoded);
		List<String> decode = decode(encoded);
		System.out.println(decode);
	}

	static public String encode(List<String> strs) {
		StringBuilder encodedString = new StringBuilder();
		for (String s : strs) {
			encodedString.append(s.length()).append("#").append(s);
		}
		return encodedString.toString();
	}

	static public List<String> decode(String str) {
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int startIndex = str.indexOf("#", i);
			int length = Integer.parseInt(str.substring(i, startIndex));
			String extractedString = str.substring(startIndex + 1, startIndex + length + 1);
			result.add(extractedString);
			i = startIndex + length + 1;
		}
		return result;
	}
}
