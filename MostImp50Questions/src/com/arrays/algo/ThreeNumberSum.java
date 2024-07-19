package com.arrays.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

	public static void main(String[] args) {
		
		int[] array = new int[] {12,3,1,2,-6,5,-8,6};
		int targetSum = 0;
		List<Integer[]> results = threeNumberSum(array,targetSum);
		results.stream().forEach(x->{
			Arrays.stream(x).forEach(y->System.out.print(y+" "));
			System.out.println();
		});
	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		List<Integer[]> results = new ArrayList<>();
		
		for(int i=0;i<array.length-2;i++) {
			int left = i+1;
			int right = array.length-1;
			while(left < right) {
				int triplet = array[i]+array[left]+array[right];
				if(triplet == targetSum) {
					results.add(new Integer[] {array[i],array[left],array[right]});
					left++; right--;
				}else if(triplet < targetSum) {
					left++;
				}else if(triplet > targetSum) {
					right--;
				}
			}
		}
		return results;
	}
}
