package com.skizmic.app.datastructures.heap;

import java.lang.reflect.Array;

/**
 * As a binary tree could possibly use a non-efficient amount of space,
 * a Binary Heap is preferably implemented with a standard array.
 * 
 * MIN HEAPS AND MAX HEAPS
 * 
 * Data Access Formulas:
 * Parent : (index - 1)/2;
 * Left Child: index * 2 + 1;
 * Right Child: index * 2 + 2;
 * 
 * Heapify (heapifying a single element):
 * Position of element in heap is wrong. Heapify is to get the element at the
 * incorrect location and relocate it within the correct location.
 * Sift Down/Sift Up
 * 
 * @author jmarcos
 *
 * @param <T>
 */
public abstract class Heap <T extends Comparable>{
	private static final int MAX_SIZE = 40;
	private T[] elems;	// Heap is based on an array
	private int count;	// Track count of elements
	
	public Heap(Class<T> clazz) {
		this(clazz, MAX_SIZE);
	}
	
	public Heap(Class<T> clazz, int size) {
		elems = (T[]) Array.newInstance(clazz, size);
	}
	
	protected abstract void siftDown(int index);
	protected abstract void siftUp(int index);
	
	public void insert(T data) throws HeapFullException {
		if(count >= elems.length) {
			throw new HeapFullException();
		}
		elems[count] = data;
		siftUp(count);
		count++;
	}
	
	public T removeHighestPriority() throws HeapEmptyException{
		T data = getHighestPriority();
		elems[0] = elems[count - 1];
		count--;
		return data;
	}
	
	public T getHighestPriority() throws HeapEmptyException {
		if(count == 0) {
			throw new HeapEmptyException();
		}
		return elems[0];
	}
	
	public int getParentIndex(int index) {
		if(index == 0 || index > count) {
			return -1;
		}
		return (index - 1)/2;
	}
	
	public int getLeftChildIndex(int index) {
		int leftChildIndex = 2*index + 1;
		if(leftChildIndex > count)
			return -1;
		return leftChildIndex;
	}
	
	public int getRightChildIndex(int index) {
		int rightChildIndex = 2*index + 2;
		if(rightChildIndex > count)
			return -1;
		return rightChildIndex;
	}
	
	protected void swap(int ind1, int ind2) {
		T temp = elems[ind1];
		elems[ind1] = elems[ind2];
		elems[ind2] = temp;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == elems.length;
	}
	
	public T getElementAtIndex(int index) {
		return elems[index];
	}
	
	public void printHeapArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(elems[i] + ", ");
        }
        System.out.println();

        try {
            System.out.println("Highest priority: " + getHighestPriority());
        } catch (HeapEmptyException ex) {

        }
    }


	public static class HeapFullException extends Exception {
    }

    public static class HeapEmptyException extends Exception {
    }
	
}
