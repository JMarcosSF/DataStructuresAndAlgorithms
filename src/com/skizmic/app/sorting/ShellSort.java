package com.skizmic.app.sorting;

public class ShellSort extends Sort {
	
	private int[] arr;
	
	public static void main(String[] args) {
		int[] arr = {4,6,1,2,9,8};
//		int[] arr = {1,2,3};
//		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		new ShellSort(arr);
		print(arr);
	}

	@Override
	void sort(int[] arr) {
		int increment = arr.length / 2;
		while(increment >= 1) {
			for(int startIndex = 0; startIndex < increment; startIndex++) {
				moddedInsertionSort(arr, startIndex, increment);
			}
			increment = increment / 2;
		}
	}
	
	public ShellSort(int[] arr) {
		this.arr = arr;
		sort(arr);
	}
	
	private void moddedInsertionSort(int[] arr, int startIndex, int increment) {
		for(int i = startIndex; i < arr.length; i = i + increment) {
			for(int j = Math.min(i + increment, arr.length - 1); 
					(j - increment) >= 0; j = j - increment) {
				if(arr[j] < arr[j - increment]) {
					swap(arr, j, j - increment);
				} else {
					break;
				}
			}
		}
	}

}
