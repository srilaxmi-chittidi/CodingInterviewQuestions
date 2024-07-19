package com.algo.easy;

public class EvaluateExpressionTree {

	public static void main(String[] args) {

	}
	public static class BST{
		int value;
		BST left;
		BST right;
		public BST(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static int evaluateTree(BST tree) {
		return inOrderTrav(tree);
	}
	
	public static boolean isLeafNode(BST node) {
		return (node.left == null && node.right == null);
	}
	public static int inOrderTrav(BST node) {
		if(isLeafNode(node)) return node.value;
		int left = inOrderTrav(node.left);
		int right = inOrderTrav(node.right);
		
		if(node.value == -1) { return left+right; }
		if(node.value == -2) { return left-right; }
		if(node.value == -3) { return (int)left/right; }
		if(node.value == -4) { return left*right; }
		
		return 0;
	}
}
