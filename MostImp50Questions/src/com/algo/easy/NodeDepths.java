package com.algo.easy;

public class NodeDepths {

	static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class BST{
		int value;
		BST left;
		BST right;
		public BST(int value) {
			this.value = value;
			this.left = null;
			this.right =null;
		}
	}
	public static void nodeDepth(BST tree,int level) {
		total +=level;
		if(tree.left != null) nodeDepth(tree.left,level+1);
		if(tree.right != null) nodeDepth(tree.right,level+1);
	}
}
