package com.altafjava.bootcamp.day6;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		int numRows1 = 5;
		List<List<Integer>> triangle1 = generate(numRows1);
		System.out.println(triangle1);

		int numRows2 = 1;
		List<List<Integer>> triangle2 = generate(numRows2);
		System.out.println(triangle2);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		result.get(0).add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			// First element in each row is always 1
			row.add(1);
			// Calculate the middle elements
			List<Integer> prevRows = result.get(i - 1);
			for (int j = 1; j < i; j++) {
				row.add(prevRows.get(j - 1) + prevRows.get(j));
			}
			// Last element in each row is always 1
			row.add(1);
			result.add(row);
		}
		return result;
	}

}
