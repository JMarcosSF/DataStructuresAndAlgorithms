package com.skizmic.app.sorting;

public class MergeSort extends Sort {
	
	public static void main(String[] args) {
//		int[] arr = {4,6,1,2,9,8};
//		int[] arr = {1,2,3};
		int[] arr = {10,9,8,7,6,5,4,3,2,1};	// This is worst case for Insertion Sort O(n^2)
		new MergeSort(arr);
		print(arr);
	}
	
	public MergeSort(int[] arr) {
		sort(arr);
	}

	@Override
	void sort(int[] arr) {
		if(arr.length == 1) {
			return;
		}
		
		int midIndex = (arr.length/2) + (arr.length%2);
		int[] halfOne = new int[midIndex];
		int[] halfTwo = new int[arr.length - midIndex];
		split(arr, halfOne, halfTwo);
		
		sort(halfOne);
		sort(halfTwo);
		
		merge(arr, halfOne, halfTwo);
	}
	
    private static void split(int[] arr, int[] halfOne, int[] halfTwo) {
        int index = 0;
        int secondHalfStartIndex = halfOne.length;
        for (int el : arr) {
            if (index < secondHalfStartIndex) {
            	halfOne[index] = el;
            } else {
            	halfTwo[index - secondHalfStartIndex] = el;
            }
            index++;
        }
    }
	
	public static void merge(int[] arr, int[] halfOne, int[] halfTwo) {
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < halfOne.length && secondHalfIndex < halfTwo.length) {
            if (halfOne[firstHalfIndex] < halfTwo[secondHalfIndex]) {
                arr[mergeIndex] = halfOne[firstHalfIndex];
                firstHalfIndex++;
            } else if (secondHalfIndex < halfTwo.length) {
                arr[mergeIndex] = halfTwo[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < halfOne.length) {
            while (mergeIndex < arr.length) {
                arr[mergeIndex++] = halfOne[firstHalfIndex++];
            }
        }
        if (secondHalfIndex < halfTwo.length) {
            while (mergeIndex < arr.length) {
                arr[mergeIndex++] = halfTwo[secondHalfIndex++];
            }
        }
    }

}
