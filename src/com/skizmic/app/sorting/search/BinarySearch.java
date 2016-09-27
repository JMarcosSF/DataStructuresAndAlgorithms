package com.skizmic.app.sorting.search;

public class BinarySearch {
	
	public static int search(int[] arr, int num) {
		int min = 0;
		int max = arr.length - 1;
		while(max > min) {
			int mid = min + (max - min) / 2;
			if(arr[mid] == num)
				return mid;
			if(arr[mid] < num) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}

}
