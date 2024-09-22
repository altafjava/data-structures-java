package com.altafjava;

import java.util.HashMap;
import java.util.Map;

public class Test {

// convert a decimal to roman no
	/*
	[3:05 PM] Hetal Goswami
I -->  1
IV -->  4
V -->  5
IX -->  9

X -->  10
XL -->  40
L -->  50
XC -->  90

C -->  100
CD -->  400
D -->  500
CM -->  900

M -->  1000
 
	 */
	public static void main(String[] args) {
		int num = 1904;
		String roman = decimalToRoman(num);
		System.out.println(roman);
	}

	static String decimalToRoman(int num) {
		StringBuilder result = new StringBuilder();
		int[] map = { 1, 4, 5, 9 };
		Map<Integer, String> romanMap = getRomanMap();
		while (num != 0) {
			for (int i = map.length - 1; i >= 0; i--) {
				int n = map[i];
				StringBuilder sb = new StringBuilder();
				sb.append(n);
				int noOfDigits = findNoOfDigits(num);
				int j = noOfDigits - 1;
				while (j != 0) {
					sb.append("0");
					j--;
				}
				int divident = Integer.parseInt(sb.toString());
				if (divident != 0) {
					int d = num / divident;
					if (d != 0) {
						String roman = romanMap.get(divident);
						result.append(roman);
						num = num % divident;
					}
				}
			}
		}
		return result.toString();
	}

	static private Map<Integer, String> getRomanMap() {
		Map<Integer, String> romanValues = new HashMap<>();
		romanValues.put(1, "I");
		romanValues.put(4, "IV");
		romanValues.put(5, "V");
		romanValues.put(9, "IX");
		romanValues.put(10, "X");
		romanValues.put(40, "XL");
		romanValues.put(50, "L");
		romanValues.put(90, "XC");
		romanValues.put(100, "C");
		romanValues.put(400, "CD");
		romanValues.put(500, "D");
		romanValues.put(900, "CM");
		romanValues.put(1000, "M");
		return romanValues;
	}

	static private int findNoOfDigits(int num) {
		return (num + "").length();
	}

}
