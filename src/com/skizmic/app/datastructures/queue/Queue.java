package com.skizmic.app.datastructures.queue;

import java.lang.reflect.Array;

public class Queue<T> {
	
	private final int SPECIAL_EMPTY_VAL = -1;
	private static int MAX_SIZE = 40;
	private T[] elems;
	
	private int headInd = SPECIAL_EMPTY_VAL;
	private int tailInd = SPECIAL_EMPTY_VAL;
	
	public Queue(Class<T> clazz) {
		elems = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}
	
	public boolean isEmpty() {
		return headInd == SPECIAL_EMPTY_VAL;
	}
	
	public boolean isFull() {
		int nextInd = (tailInd + 1) % elems.length;
		return nextInd == headInd;
	}
	
	public void enqueue(T data) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		tailInd = (tailInd + 1) % elems.length;
		elems[tailInd] = data;
		
		if(headInd == SPECIAL_EMPTY_VAL) {
			headInd = tailInd;
		}
	}
	
	public T dequeue() throws QueueUnderflowException{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T data = elems[headInd];
		
		if(headInd == tailInd) {
			headInd = SPECIAL_EMPTY_VAL;
		} else {
			headInd = (headInd + 1) % elems.length;
		}
		return data;
	}
	
    public static class QueueOverflowException extends Exception {
    }

    public static class QueueUnderflowException extends Exception {
    }
    
    public static void main(String[] args) {
    	Queue<Integer> q = new Queue<Integer>(Integer.class);
    	
    	try {
    		for(int i = 0; i < Queue.MAX_SIZE; i++) {    			
    			q.enqueue((int) (Math.random()*10));
    		}
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
		} catch (QueueUnderflowException e) {
			
		}catch (QueueOverflowException e) {
			e.printStackTrace();
		}    	
    }

}
