package com.altafjava.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
735. Asteroid Collision
https://leetcode.com/problems/asteroid-collision/description/

We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0
*/
public class AsteroidCollision {

	public static void main(String[] args) {
		int[] asteroids = { 5, 10, -5 };
//		int[] asteroids = { 8, -8 };
//		int[] asteroids = { 10, 2, -5 };
//		int[] asteroids = { 5, 10, -15 };
		System.out.println("Before Collide: " + Arrays.toString(asteroids));
		int[] result = asteroidCollision(asteroids);
		System.out.println("After Collide: " + Arrays.toString(result));
	}

	static public int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> stack = new ArrayDeque<Integer>(asteroids.length);
		for (int asteroid : asteroids) {
			boolean isAsteroidAlive = true;
			while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && isAsteroidAlive) {
				int top = stack.peek();
				int asteroidAbs = Math.abs(asteroid);
				if (top == asteroidAbs) {
					stack.pop();
					isAsteroidAlive = false;
				} else if (top > asteroidAbs) {
					isAsteroidAlive = false;
				} else {
					stack.pop();
				}
			}
			if (isAsteroidAlive)
				stack.push(asteroid);
		}
		int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
	}
}
