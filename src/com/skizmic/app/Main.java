package com.skizmic.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.skizmic.app.datastructures.queue.Queue;

public class Main {
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,2};
		rotateArray(arr);
		System.out.println(isPalindrome(arr));
		reverseString1("Hello");
		reverseString2("Hello");
		System.out.println(factorial(3));
	}
	
	public static void rotateArray(int[] arr) {
		int tmp = arr[0];
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;
	}
	
	public static int factorial(int n) {
		if(n == 0)
			return 1;
		return factorial(n - 1) * n;
	}
	
	public static String reverseString1(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		System.out.println(str.substring(1) + str.charAt(0));
		return reverseString1(str.substring(1)) + str.charAt(0);
	}
	
	public static String reverseString2(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = str.length() - 1; i >=0 ; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static boolean isPalindrome(int[] arr) {
		if(arr.length == 1)
			return true;
		int x = 0;
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] != arr[x])
				return false;
			x++;
		}
		return true;
	}
	
	// Print Fib Sequent up to user specified max
	static void printFibSeq(int max) {
		long x = 0;
		long y = 1;
		System.out.print(x + " ");
		while(x < max) {
		    x = x + y;
		    y = x - y;
		    System.out.print(x + " ");
		}
	}
	
	// Binary Tree impl with breadt first search
	static class BinaryTree {
		private static TreeNode top;
		
		public BinaryTree(TreeNode top) {
			BinaryTree.top = top;
		}
		
		public void add(TreeNode parent, TreeNode child, String side) {
			if(side.equals("left")) {
				parent.left = child;
			}
			if(side.equals("right")) {
				parent.right = child;
			}
		}
		
		private static void printBFT(TreeNode top) {
			Queue<TreeNode> q = new Queue<TreeNode>(TreeNode.class);
			try {
				q.enqueue(top);
				while(!q.isEmpty()) {
					TreeNode node = q.dequeue();
					System.out.print(node.data);
					if(node.left != null)
						q.enqueue(node.left);
					if(node.right != null)
						q.enqueue(node.right);
				}
			} catch (Queue.QueueOverflowException e) {
				e.printStackTrace();
			} catch (Queue.QueueUnderflowException e) {
				e.printStackTrace();
			}
		}

		public static TreeNode getTop() {
			return top;
		}

		public static void setTop(TreeNode top) {
			BinaryTree.top = top;
		}
		
	}
	
	// Tree Node for Binary Tree
	static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		
	}
	
}
