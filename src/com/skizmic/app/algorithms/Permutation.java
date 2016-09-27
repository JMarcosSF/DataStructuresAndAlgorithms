package com.skizmic.app.algorithms;

public class Permutation {
	
	public static void main(String[] args) {
		int[] permArr = {1,3,2,4};
		permutate(permArr);
	}
	
	public static void permutate(int[] arr) {
		permStep(arr, arr.length);
	}
	
	private static void permStep(int[] arr, int n) {
        if (n == 1) {
//            printArr(arr);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(arr, i, n-1);
            permStep(arr, n-1);
            swap(arr, i, n-1);
        }
	}
	
	private static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
		printArr(arr);
	}
	
	private static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
