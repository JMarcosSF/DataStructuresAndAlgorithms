package com.skizmic.app.sorting;

import com.skizmic.app.sorting.search.BinarySearch;

public class QuickSort extends Sort {
	
	private static int[] arr;
	
	public static void main(String[] args) {
//		int[] arr = {4,6,1,2,9,8};
//		int[] arr = {1,2,3};
		int[] arr = {10,9,8,7,6,5,4,3,2,1};	// This is worst case for Insertion Sort O(n^2)
		new QuickSort(arr);
		print(arr);
		int target = 3;
		int targetIndex = BinarySearch.search(arr, target);
		System.out.println(arr[targetIndex]);
	}

	public QuickSort(int[] arr) {
		this.arr = arr;
		sort(arr);
	}
	
	@Override
	void sort(int[] arr) {
		quickSort(0, arr.length - 1);
	}
	
	void quickSort(int lo, int hi) {
		if(hi <= lo)
			return;
		int pivPos = quickSortStep(lo, hi);
		quickSort(lo, pivPos - 1);
		quickSort(pivPos + 1, hi);
	}
	
	int quickSortStep(int lo, int hi) {
		int pivot = arr[lo];
		while(hi > lo) {
			while(hi > lo && arr[hi] >= pivot) {
				hi--;
			}
			if(hi == lo)
				break;
			arr[lo] = arr[hi];
			lo++;
			while(hi > lo && arr[hi] < pivot) {
				lo++;
			}
			if(hi == lo)
				break;
			arr[hi] = arr[lo];
			hi--;
		}
		arr[lo] = pivot;
		return lo;
	}

}
