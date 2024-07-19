package com.arrays.algo;

import java.util.Arrays;

public class LongestPeak {

	public static void main(String[] args) {
		System.out.println(peak(new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3}));
	}
	public static int peak(int[] intArr) {
		int result = 0;
		int size = intArr.length;
		int[] left = new int[size];
		
		for(int i=1;i<size;i++) {
			if(intArr[i-1]<intArr[i]) {
				left[i] = left[i-1]+1;
			}
		}
		int[] right = new int[size];
		for(int j=size-2;j>=0;j--) {
			if(intArr[j]>intArr[j+1]) {
				right[j] = right[j+1]+1;
			}
		}
		int max = 0;
		for(int i =0 ;i<size;i++) {
			if(left[i] != 0 && right[i] != 0) {
				max = Math.max(left[i]+right[i]+1, i);
				System.out.print(max+" ");
			}
		}
		System.out.println("-----------"+max);

		Arrays.stream(left).forEach(x->System.out.print(x+" "));
		System.out.println();
		Arrays.stream(right).forEach(x->System.out.print(x+" "));
		return result;
	}
}
