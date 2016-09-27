package com.skizmic.app.datastructures.stack;

import com.skizmic.app.datastructures.queue.Queue;
import com.skizmic.app.datastructures.queue.Queue.QueueOverflowException;



/**
 * Queue implemented with Two Stacks
 * Enqueued elements pushed to Forward Stack.
 * Dequed elemments popped from Reverse Stack.
 * @author Juan Marcos
 *
 */
public class TwoStackQueue {
	
	private Stack<Integer> forward = new Stack<>();
	private Stack<Integer> reverse = new Stack<>();
	
	// Enqueue always occurs on the forward stack
	public void enqueue(int data) throws QueueOverflowException {
		if(isFull()) {
			throw new StackOverflowError();
		}
		
		try {
            if (forward.isEmpty()) {
                while (!reverse.isEmpty()) {
                	forward.push(reverse.pop());
                }
             }
            forward.push(data);
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException se) {
            throw new Queue.QueueOverflowException();
        }
	}
	
	// Dequeue always occurs on the reverse stack
	public int dequeue() throws Queue.QueueUnderflowException {
		if(isEmpty()) {
			throw new Queue.QueueUnderflowException();
		}
		
		try {
            if (reverse.isEmpty()) {
                while (!forward.isEmpty()) {
                    reverse.push(forward.pop());
                }
            }

            return reverse.pop();
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException se) {
            throw new Queue.QueueUnderflowException();
        }
	}

	public boolean isFull() {
		return forward.isFull() || reverse.isFull();
	}
	
	public boolean isEmpty() {
		return forward.isEmpty() || reverse.isEmpty();
	}

}