package com.altafjava.leetcode.array.hard;

public class MedianOf2SortedArray {

	public static void main(String[] args) {
//		int[] nums1 = { 3, 7, 9, 15, 18, 21, 25 };
//		int[] nums2 = { 4, 6, 8, 10, 11, 18 };
//		int[] nums1 = { 1, 3 };
//		int[] nums2 = { 2 };
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		double median = new MedianOf2SortedArray().findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merged = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				merged[k++] = nums1[i++];
			} else if (nums1[i] > nums2[j]) {
				merged[k++] = nums2[j++];
			} else {
				merged[k++] = nums1[i++];
			}
		}
		while (i < nums1.length) {
			merged[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			merged[k++] = nums2[j++];
		}
		int half = merged.length / 2;
		if (merged.length % 2 == 0) {
			return (merged[half] + merged[half - 1]) / 2.0;
		} else {
			return merged[half];
		}
	}

}
