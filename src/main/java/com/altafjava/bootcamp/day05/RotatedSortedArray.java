package com.altafjava.bootcamp.day05;

/*
  Search an element in the Sorted Array
  
  1. Divide the array into two parts[mid=(low+high)/2] and check which part is sorted.
  2. After dividing one half (either the left or the right) will always be sorted.
  3. If the left part is sorted then right part won't be sorted. vice-versa.
  5. If the low element is less than & equals to mid element, then left part is sorted. Else right part is sorted.
  6. Always find the target in sorted part.
  7. If left part is sorted:
  		a. Check the target lies in which part.
  		b. If low element is less than the target element & target element is less than the mid element then the target lies under left part.
  		c. otherwise target falls under right part.
  		d. If target present in the left part then move the high to mid-1.
  		e. If target present in the right part then move the low to mid+1.
  8. If right part is sorted:
  		a. Check the target lies in which part.
  		b. If mid element is less than the target element & target element is less than the high element then the target lies under right part.
  		c. otherwise target falls under left part.
  		d. If target present in the right part then move the low to mid+1.
  		e. If target present in the left part move the high to mid-1.
  9. If target equals to mid element then return the mid value.
 */
public class RotatedSortedArray {

	public static void main(String[] args) {
//		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }, key = 7;
//		int arr[] = { 8, 0, 1, 2, 3, 4, 5, 6, 7 }, key = 5;
//		int arr[]= {4,5,6,7,0,1,2}, key=0;
//		int arr[]= {4,5,6,7,0,1,2}, key=3;
		int arr[] = { 1 }, key = 0;
		int search = search(arr, key);
		System.out.println(search);
	}

	public static int search(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == arr[mid]) {
				return mid;
			}
			if (arr[low] <= arr[mid]) {
				if (arr[low] <= target && target < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (arr[mid] < target && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}
