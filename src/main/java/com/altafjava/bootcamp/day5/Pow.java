package com.altafjava.bootcamp.day5;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:
    -100.0 < x < 100.0
    -231 <= n <= 231-1
    n is an integer.
    Either x is not zero or n > 0.
    -104 <= xn <= 104
    
Time Complexity: O(logN)
Space Complexity: O(logN)
*/

public class Pow {
	public static void main(String[] args) {
		System.out.println(myPow(2.00000, 10)); // Output: 1024.00000
		System.out.println(myPow(2.10000, 3)); // Output: 9.26100
		System.out.println(myPow(2.00000, -2)); // Output: 0.25000
	}

	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		return powHelper(x, n);
	}

	private static double powHelper(double x, int n) {
		if (n == 0)
			return 1;
		double half = powHelper(x, n / 2);
		if (n % 2 == 0)
			return half * half;
		else
			return x * half * half;
	}
}
