package com.skizmic.app.datastructures.binarytree;

import com.skizmic.app.datastructures.binarytree.BinaryTree.TreeNode;

public class BinarySearchTree extends BinaryTree {
	
	public static void main(String[] args) {
		TreeNode<Integer> tn1 = new TreeNode<Integer>(1);
		TreeNode<Integer> tn2 = new TreeNode<Integer>(2);
		TreeNode<Integer> tn3 = new TreeNode<Integer>(3);
		TreeNode<Integer> tn4 = new TreeNode<Integer>(4);
		TreeNode<Integer> tn5 = new TreeNode<Integer>(5);
		TreeNode<Integer> tn6 = new TreeNode<Integer>(6);
		TreeNode<Integer> tn7 = new TreeNode<Integer>(7);
		TreeNode<Integer> tn8 = new TreeNode<Integer>(8);
		BinarySearchTree bst = new BinarySearchTree(tn1);
		bst.insert(bst.getRoot(), tn2);
		bst.insert(bst.getRoot(), tn4);
		bst.insert(bst.getRoot(), tn3);
		bst.insert(bst.getRoot(), tn6);
		bst.insert(bst.getRoot(), tn5);
		bst.insert(bst.getRoot(), tn7);
		bst.insert(bst.getRoot(), tn8);
		System.out.print("Breadth First: ");
		breadthFirstBT(bst.getRoot());
		System.out.print("Pre-Order: ");
		preOrder(bst.getRoot());
		System.out.print("In-Order: ");
		inOrder(bst.getRoot());
		System.out.print("Post-Order: ");
		postOrder(bst.getRoot());
		System.out.println("\nLooking up: " + lookUp(bst.getRoot(),4).getData());
		System.out.println("MIN VAL:" + minimumValue(bst.getRoot()));
		System.out.println("MAX DEPTH:" + maxDepth(bst.getRoot()));
	}
	
	public BinarySearchTree(TreeNode<Integer> root) {
		super(root);
	}
	
	public static TreeNode<Integer> insert(TreeNode<Integer> root, TreeNode<Integer> node) {
		
		if(root == null)
			return node;
		
		if(node.getData() <=  root.getData()) {
			root.setLeftNode(insert(root.getLeftNode(), node));
		} else {
			root.setRightNode(insert(root.getRightNode(), node));
		}
		
		return root;
	}
	
	public static TreeNode<Integer> lookUp(TreeNode<Integer> root, int data) {
		if(root == null) {
			return null;
		}
		
		if(root.getData() == data)
			return root;
		
		if(data <= root.getData()) {
			return lookUp(root.getLeftNode(), data);
		} else {
			return lookUp(root.getRightNode(), data);
		}
		
	}
	
	public static int minimumValue(TreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		if(root.getLeftNode() == null)
			return root.getData();
		
		return minimumValue(root.getLeftNode());
	}
	
	public static int maxDepth(TreeNode<Integer> root) {
		if(root == null)
			return 0;
		
		if(root.getLeftNode() == null && root.getRightNode() == null)
			return 0;
		
		int leftDepth = 1 + maxDepth(root.getLeftNode());
		int rightDepth = 1 + maxDepth(root.getRightNode());
		return Math.max(leftDepth, rightDepth);
	}
	
}
