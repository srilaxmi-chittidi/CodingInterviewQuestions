package com.arrays.algo;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {

	public static void main(String[] args) {
		System.out.println(zeroSumSubArray(new int[] {4,-3,2,4,-1,-5,7}));
	}

	public static boolean zeroSumSubArray(int[] intArr) {
		
		Set<Integer> set = new HashSet<>();
		set.add(0);
		int sum = 0;
		for(int num : intArr) {
			sum += num;
			if(set.contains(sum)) {
				return true;
			}
			set.add(sum);
		}
		return false;
	}
}
