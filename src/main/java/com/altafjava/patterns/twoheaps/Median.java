package com.altafjava.patterns.twoheaps;

import java.util.PriorityQueue;

/**
 * Design a class to calculate the median of a number stream. The class should have the following two methods:</br>
 * insertNum(int num): stores the number in the class</br>
 * findMedian(): returns the median of all numbers inserted in the class</br>
 * If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 */
public class Median {
	private PriorityQueue<Integer> smallDescHeap;
	private PriorityQueue<Integer> bigAscHeap;

	public Median() {
		smallDescHeap = new PriorityQueue<>((a, b) -> b - a);
		bigAscHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	public static void main(String[] args) {
		Median medianOfAStream = new Median();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}

	/**
	 * Stores the number in the class</br>
	 * The time complexity of the insertNum() will be O(logN) due to the insertion in the heap.</br>
	 * The space complexity will be O(N) because, as at any time, we will be storing all the numbers.
	 * 
	 * @param num
	 */
	public void insertNum(int num) {
		if (smallDescHeap.isEmpty() || smallDescHeap.peek() >= num)
			smallDescHeap.add(num);
		else
			bigAscHeap.add(num);
		if (smallDescHeap.size() > bigAscHeap.size() + 1)
			bigAscHeap.add(smallDescHeap.poll());
		else if (smallDescHeap.size() < bigAscHeap.size())
			smallDescHeap.add(bigAscHeap.poll());
	}

	/**
	 * Returns the median of all numbers inserted in the class</br>
	 * The time complexity of the findMedian() will be O(1) as we can find the median from the top elements of the heaps.
	 * 
	 * @return median
	 */
	public double findMedian() {
		if (smallDescHeap.size() == bigAscHeap.size())
			return (smallDescHeap.peek() + bigAscHeap.peek()) / 2.0;
		return smallDescHeap.peek();
	}

}
