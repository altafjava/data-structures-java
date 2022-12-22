package com.altafjava.string;

import java.util.Map;
import java.util.stream.Collectors;

public class CharOccurences {

	public static void main(String[] args) {
		String s = "messages";
		Map<Character, Long> map = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(map);
	}

}
