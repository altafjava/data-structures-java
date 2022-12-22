package com.altafjava.patterns.bitwisexor;

/**
 * For a given positive number N in base-10, return the complement of its binary representation as a base-10
 * integer.</br>
 * Every non-negative integer N has a binary representation, for example, 8 can be represented as “1000” in binary and 7
 * as “0111” in binary.</br>
 * The complement of a binary representation is the number in binary that we get when we change every 1 to a 0 and every
 * 0 to a 1. For example, the binary complement of “1010” is “0101”.</br>
 * </br>
 * Input: 8</br>
 * Output: 7</br>
 * Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10.</br>
 * </br>
 * Input: 10</br>
 * Output: 5</br>
 * Explanation: 10 is 1010 in binary, its complement is 0101 in binary, which is 5 in base-10.</br>
 * 
 */
public class ComplementNumber {

	public static void main(String[] args) {
		System.out.println("Biwise Complement is: " + findBitwiseComplement(8));
		System.out.println("Biwise Complement is: " + findBitwiseComplement(10));
	}

	private static int findBitwiseComplement(int num) {
		int n = num;
		int bitCount = 0;
		while (n > 0) {
			bitCount++;
			n = n >> 1;
		}
		int allOneBits = (int) Math.pow(2, bitCount) - 1;
		return num ^ allOneBits;
	}

}
