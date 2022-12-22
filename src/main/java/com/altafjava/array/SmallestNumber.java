package com.altafjava.array;

public class SmallestNumber {

	static int getSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}
		return sum;
	}

	// Function to find the smallest
	// number whose sum of digits is also N
	static int smallestNumber(int N) {
		int i = 1;
		while (true) {
			// Checking if number has
			// sum of digits = N
			if (getSum(i) == N) {
//				System.out.print(i);
//				break;
				return i;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 30; i++) {
			int smallestNumber = smallestNumber(i);
			System.out.println(i + " " + smallestNumber);
		}
	}
}
