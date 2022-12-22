package com.altafjava.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.</br>
 * Input: [1, 3]</br>
 * Output: [], [1], [3], [1,3]</br>
 * </br>
 * Input: [1, 5, 3]</br>
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {

	public static void main(String[] args) {
		List<List<Integer>> result = findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
		result = findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

	/**
	 * <b>Time Complexity:</b> Since, in each step, the number of subsets doubles as we add each element to all the existing
	 * subsets, the time complexity of the above algorithm is O(2^N)O(2 ​N ​​ ), where ‘N’ is the total number of elements
	 * in the input set. This also means that, in the end, we will have a total of O(2^N) subsets.</br>
	 * <b>Space Complexity:</b> All the additional space used by our algorithm is for the output list. Since we will have a
	 * total of O(2^N)O(2 ​N ​​ ) subsets, the space complexity of our algorithm is also O(2^N).
	 * 
	 * @param nums
	 * @return list
	 */
	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());
		for (int n : nums) {
			int size = subsets.size();
			for (int i = 0; i < size; i++) {
				List<Integer> set = new ArrayList<>(subsets.get(i));
				set.add(n);
				subsets.add(set);
			}
		}
		return subsets;
	}
}
