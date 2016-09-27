package com.skizmic.app.datastructures.binarytree;

import com.skizmic.app.datastructures.queue.Queue;
import com.skizmic.app.datastructures.queue.Queue.QueueOverflowException;
import com.skizmic.app.datastructures.queue.Queue.QueueUnderflowException;

public class BinaryTree {
	
	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(6);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn8 = new TreeNode(8);
		BinaryTree bt = new BinaryTree(tn1);
		bt.add(bt.getRoot(), tn2, "left");
		bt.add(bt.getRoot(), tn3, "right");
		bt.add(tn2, tn4, "right");
		bt.add(tn3, tn5, "left");
		bt.add(tn3, tn6, "right");
		bt.add(tn6, tn7, "left");
		bt.add(tn6, tn8, "right");
		
		System.out.println("Breadth First: ");
		breadthFirstBT(bt.getRoot());
		
		System.out.println("\nPre-Order: ");
		preOrder(bt.getRoot());
		
		System.out.println("\nIn-Order: ");
		inOrder(bt.getRoot());
		
		System.out.println("\nPost Order: ");
		postOrder(bt.getRoot());
		
		System.out.println("\nMirroring:");
		mirror(bt.root);
		breadthFirstBT(bt.root);
	}
	
	TreeNode root;
	
	public BinaryTree() {
		
	}
	
	public BinaryTree(TreeNode root) {
		this.root = root;
	}
	
	public void add(TreeNode parent, TreeNode child, String side) {
		if(side.equals("left"))
			parent.setLeftNode(child);
		if(side.equals("right"))
			parent.setRightNode(child);
	}
	
	public static void breadthFirstBT(TreeNode root) {
		Queue<TreeNode> q = new Queue<TreeNode>(TreeNode.class);
		try {
			q.enqueue(root);
			while(!q.isEmpty()) {
				TreeNode node = q.dequeue();
				System.out.print(node.data + " ");
				if(node.getLeftNode() != null)
					q.enqueue(node.getLeftNode());
				if(node.getRightNode() != null)
					q.enqueue(node.getRightNode());
			}
		} catch (Queue.QueueOverflowException e) {
			e.printStackTrace();
		} catch (Queue.QueueUnderflowException e) {
			e.printStackTrace();
		}
	}
	
	public static void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.getLeftNode());
		System.out.print(root.data + " ");
		inOrder(root.getRightNode());
	}
	
	public static void postOrder(TreeNode root) {
		if(root == null)
			return;
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.print(root.data + " ");
	}
	
	public static void mirror(TreeNode<Integer> root) {
		if(root == null)
			return;
		
		mirror(root.getLeftNode());
		mirror(root.getRightNode());
		
		TreeNode<Integer> tmp = root.getLeftNode();
		root.setLeftNode(root.getRightNode());
		root.setLeftNode(tmp);
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public TreeNode getRoot() {
		return root;
	}
	
	static class TreeNode<T> {
		private TreeNode leftNode;
		private TreeNode rightNode;
		T data;
		
		public TreeNode(T data) {
			this.data = data;
		}
		
		public TreeNode getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(TreeNode leftNode) {
			this.leftNode = leftNode;
		}
		public TreeNode getRightNode() {
			return rightNode;
		}
		public void setRightNode(TreeNode rightNode) {
			this.rightNode = rightNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
	}

}
