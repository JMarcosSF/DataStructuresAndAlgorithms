package com.skizmic.app.datastructures.heap;

public class MinHeap<T extends Comparable> extends Heap<T> {

	public MinHeap(Class<T> clazz) {
		super(clazz);
	}
	
	public MinHeap(Class<T> clazz, int size) {
		super(clazz, size);
	}
	
    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();
        minHeap.insert(6);
        minHeap.printHeapArray();

        minHeap.insert(100);
        minHeap.insert(20);
        minHeap.printHeapArray();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
    }

	@Override
	protected void siftDown(int index) {
		int leftInd = getLeftChildIndex(index);
		int rightInd = getRightChildIndex(index);
		
		int smallerInd = -1;
		// Case if both left and right are present
		if(leftInd != -1 && rightInd != -1) {
			smallerInd = getElementAtIndex(leftInd)
					.compareTo(getElementAtIndex(rightInd)) < 0 ? leftInd : rightInd;
		} else if(leftInd != -1) {
			smallerInd = leftInd;
		} else if(rightInd != -1) {
			smallerInd = rightInd;
		}
		
		if(smallerInd == -1) {
			return;
		}
		
		if(getElementAtIndex(smallerInd).compareTo(getElementAtIndex(index)) < 0) {
			swap(smallerInd, index);
			siftDown(smallerInd);
		}
		
	}

	@Override
	protected void siftUp(int index) {
		int parentInd = getParentIndex(index);
		
		if(parentInd != -1 &&
				getElementAtIndex(index).compareTo(getElementAtIndex(parentInd)) < 0) {
			swap(index, parentInd);
			siftUp(parentInd);
		}
	}

}
