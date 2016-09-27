package com.skizmic.app.sorting;

public abstract class Sort {
	
	public static void main(String[] args) {
		
	}
	
	abstract void sort(int[] arr);

	public static void print(int[] arr) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
