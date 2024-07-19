package com.algo.easy;

public class FindClosestValueInBST {

	public static void main(String[] args) {

	}
	public static class BST{
		int value;
		BST left;
		BST right;
		BST(int value){
			this.value =value;
		}
	}
	public static int findClosestValue(BST tree,int target) {
		int closest = 0;
		int absDiff = Integer.MAX_VALUE;
		int currDiff = Math.abs(tree.value-target);
		if(currDiff < absDiff) {
			absDiff = currDiff;
			closest = tree.value;
		}
		if(tree.value == target) return tree.value;
		if(tree.value > target) { 
			tree = tree.left;
		}
		else if(tree.value < target) { 
			tree = tree.right;
		}
		return closest;
		
	}
}
