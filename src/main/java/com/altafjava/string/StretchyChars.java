package com.altafjava.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
People usually text stressed words when they get excited. 
A stressed word means one or more characters appear more than they should.
Ex: hellllooooo -- l and o are stressed characters here.

Problem Statement:
===================
Write a function which takes the string as input and
return details of stressed characters and the range they got stressed

Ex: For "hellllooooo", returned data should contain below information
l stressed from index 2 to 5
o stressed from index 6 to 10

Note: Consider a character is stressed if it appears more than 2 times continuously. 
Use any collection or any custom data structure as return type.
 */
public class StretchyChars {
	public static void main(String[] args) {
//		String s = "helllloooooll";
		String s = "hellllooooolll";
		Pattern pattern = Pattern.compile("(\\w)\\1\\1+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			System.out.println(matcher.group() + " " + matcher.start() + " " + (matcher.end() - 1));
		}
	}
}
//Output:
//============
//llll 2 5
//ooooo 6 10
//lll 11 13
