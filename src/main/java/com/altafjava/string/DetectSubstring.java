package com.altafjava.string;

public class DetectSubstring {

	public static void main(String[] args) {
		String str = "home is where your cat is";
//		String substring = "cat";
		String substring = "home";
		boolean isPresent = new DetectSubstring().detectSubstringInString(str, substring);
		System.out.println(isPresent);
	}

	public boolean detectSubstringInString(String str, String substring) {
		int windowSize = substring.length();
		for (int i = 0; i < str.length(); i++) {
			String sub = str.substring(i, windowSize + i);
			if (sub.equals(substring)) {
				System.out.println("startIndex:" + i + "  endIndex:" + (i + windowSize - 1));
				return true;
			}
		}
		return false;
	}

}
