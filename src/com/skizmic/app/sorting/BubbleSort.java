package com.skizmic.app.sorting;

public class BubbleSort extends Sort{
	
	public static void main(String[] args) {
//		int[] arr = {4,6,1,2,9,8};
//		int[] arr = {1,2,3};
		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		new BubbleSort(arr);
		print(arr);
	}
	
	public BubbleSort(int[] arr) {
		sort(arr);
	}

	@Override
	void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			boolean swapped = false;
			for(int j = arr.length - 1; j > i; j--) {
				if(arr[i] > arr[j]) {					
					swap(arr, i, j);
					swapped = true;
				}
			}
			print(arr);
			if(!swapped) {
				break;
			}
			System.out.println(i + ":"+swapped);
		}
	}

}
