package com.skizmic.app.sorting;

/**
 * Insertion Sort creates a sublist at the beginning of the list
 * and compares each following index to the elements within
 * this sublist.
 * @author jmarcos
 *
 */
public class InsertionSort extends Sort {
	
	public static void main(String[] args) {
//		int[] arr = {4,6,1,2,9,8};
//		int[] arr = {1,2,3};
		int[] arr = {10,9,8,7,6,5,4,3,2,1};	// This is worst case for Insertion Sort O(n^2)
		new InsertionSort(arr);
		print(arr);
	}

	public InsertionSort(int[] arr) {
		sort(arr);
	}
	

	@Override
	void sort(int[] arr) {
		int it = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j > 0; j--) {
				// Continue to compare current element to elements
				// in the sublist.
				// If it is no longer lt, we have found it's new spot, so break
				if(arr[j] < arr[j - 1]) {
					print(arr);
					swap(arr, j, j - 1);
					print(arr);
					System.out.println();
				}else {
					break;
				}
			}
		}
	}

}
