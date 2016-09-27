package com.skizmic.app.datastructures.stack;

import com.skizmic.app.datastructures.stack.Stack.StackOverflowException;
import com.skizmic.app.datastructures.stack.Stack.StackUnderflowException;

public class StackFindMinimumElementInConstantTime {

	private static Stack<Integer> testStack = new Stack<Integer>();
	private static Stack<Integer> minStack = new Stack<Integer>();
	
	static{
		int[] input = {90,84,36,57,78,42};
		try {
			// Insert first element into minStack.
			minStack.push(input[0]);
			for(int i = 0; i < input.length; i++) {
				testStack.push(input[i]);
				if(input[i] < minStack.peek()) {
					minStack.push(input[i]);
				}
			}
		} catch (StackOverflowException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		try {
			minPop();
			minPush(78);
			minPush(27);
			minPush(29);
			minPush(38);
		} catch (StackOverflowException e1) {
			e1.printStackTrace();
		} catch (StackUnderflowException e1) {
			e1.printStackTrace();
		}
		while(true) {
			try {
				sb1.append(testStack.pop() + " ");
			} catch (StackUnderflowException e) {
				break;
			}
		}
		while(true) {
			try {
				sb2.append(minStack.pop() + " ");
			} catch (StackUnderflowException e) {
				break;
			}
		}
		
		System.out.println("1: " +sb1.toString());
		System.out.println("2: " + sb2.toString());
	}
	
	static void minPush(int num) throws StackOverflowException, StackUnderflowException {
		if(num < minStack.peek()) {				
			minStack.push(num);
		}else {
			minStack.push(minStack.peek());
		}
		testStack.push(num);
	}
	
	static int minPop() throws StackOverflowException, StackUnderflowException {
//		System.out.println(minStack.pop());
		minStack.pop();
		return testStack.pop();
	}
	
}
