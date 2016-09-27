package com.skizmic.app.sorting;

import java.lang.reflect.Array;
/**
 * Selection Sort O(n^2)
 * @author skizmic
 *
 */
public class SelectionSort extends Sort{

	public static void main(String[] args) {
		int[] arr = {4,6,1,2,9,8};
		new SelectionSort(arr);
		print(arr);
	}
	
	public SelectionSort(int[] arr) {
		sort(arr);
	}
	
	@Override
	public void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				int tmp;
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	

}
