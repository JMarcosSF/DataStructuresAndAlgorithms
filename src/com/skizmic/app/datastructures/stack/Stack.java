package com.skizmic.app.datastructures.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Stack<T> {
	
	private static int MAX_SIZE = 40;
	private Element<T> top;
	private int size = 0;

	public Stack() {
		
	}
	
	public void push(T data) throws StackOverflowException {
		if(size == MAX_SIZE) {
			throw new Stack.StackOverflowException();
		}
		Element elem = new Element(data, top);
		top = elem;
		size++;
	}
	
	public T pop() throws StackUnderflowException {
		if(size == 0) {
			throw new Stack.StackUnderflowException();
		}
		T data = top.getData();
		top = top.getNext();
		size--;
		return data;
	}
	
	public T peek() throws StackUnderflowException {
		if(size == 0) {
			throw new Stack.StackUnderflowException();
		}
		return top.getData();
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
    public static class Element<T> {
        private T data;
        private Element next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public static class StackOverflowException extends Exception {
    }

    public static class StackUnderflowException extends Exception {
    }

}
