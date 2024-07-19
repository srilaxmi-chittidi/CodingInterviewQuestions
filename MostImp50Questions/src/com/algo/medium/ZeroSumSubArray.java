package com.algo.medium;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {

	public static void main(String[] args) {
		int[] nums = new int[] {-5,-5,2,3,-2};
		System.out.println(zeroSumSubArray(nums));
	}

	public static boolean zeroSumSubArray(int[] nums) {
		int sum = 0;
		Set<Integer> set = new HashSet<>();
		set.add(0);
		for(int num :nums) {
			sum += num;
			set.forEach(x->System.out.print(x+" "));
			if(set.contains(sum)) {
				return true;
			}
			set.add(sum);
			System.out.println();
			
		}
		return false;
	}
}
