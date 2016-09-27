package com.skizmic.app.datastructures.linkedlist;

public class LinkedList<T extends Comparable<T>> implements Cloneable {
	
	private Node<T> head = null;
	
	public LinkedList(Node<T> head) {
		this.head = head;
	}
	
	public static void main(String[] args) {
		Node head = new Node<Integer>(0);
		LinkedList<Integer> ll1 = new LinkedList<>(head);
	}
	
	public void addNode(T data) {
		if(head == null) {
			Node node = new Node(data);
			head = node;
		}else {
			Node curr = head;
			while(curr.hasNext()) {
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
	}
	
	public Node<T> pop() {
		if(head == null) {
			return null;
		}else {
			Node curr = head;
			head = head.getNext();
			return curr;
		}
	}
	
	public int countNodes() {
		if(head == null) {
			return 0;
		}else {
			Node<T> curr = head;
			int count = 0;
			while(curr != null) {
				curr = curr.getNext();
				count++;
			}
			return count;
		}
	}
	
	public static class Node<T extends Comparable<T>> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			
		}
		
		public boolean hasNext() {
			return next != null;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return String.valueOf(data);
		}
	}
}
