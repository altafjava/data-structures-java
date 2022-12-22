package com.altafjava.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {

	public static void main(String[] args) {
		List<List<Integer>> result = findPermutations(new int[] { 1, 3, 5 });
		System.out.print("Here are all the permutations: " + result);
	}

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());
		for (int n : nums) {
			int size = permutations.size();
			for (int i = 0; i < size; i++) {
				List<Integer> oldPermutation = permutations.poll();
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<>(oldPermutation);
					newPermutation.add(j, n);
					if (newPermutation.size() == nums.length)
						result.add(newPermutation);
					else
						permutations.add(newPermutation);
				}
			}
		}
		return result;
	}

}
