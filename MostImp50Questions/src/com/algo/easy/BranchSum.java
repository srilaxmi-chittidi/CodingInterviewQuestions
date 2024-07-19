package com.algo.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {

	public static void main(String[] args) {
	}
	public static class BST {
		int value;
		BST left;
		BST right;
		public BST(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	public static List<Integer> branchSum(BST tree) {
		List<Integer> results = new ArrayList<>();
		
		sum(tree,0,results);
		return results;
	}
	public static void sum(BST tree,int sum, List<Integer> results) {
		
		if(tree==null) return;
		if(tree.left == null && tree.right == null) {
			results.add(sum+tree.value);
			return;
		}
		sum(tree.left,sum+tree.value,results);
		sum(tree.right,sum+tree.value,results);
		
	}

}
