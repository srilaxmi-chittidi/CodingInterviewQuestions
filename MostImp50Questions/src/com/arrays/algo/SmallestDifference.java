package com.arrays.algo;

import java.util.Arrays;

public class SmallestDifference {

	public static void main(String[] args) {
		int[] arrayOne = new int[] {-1,5,10,20,28,3};
		int[] arrayTwo = new int[] {26,134,135,15,17};
		
		int[] results = smallestDiff(arrayOne, arrayTwo);
		Arrays.stream(results).forEach(x->System.out.println(x+" "));
	}
	public static int[] smallestDiff(int[] arrayOne , int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		int pointerOne = 0; int pointerTwo =0;
		int[] results = new int[] {arrayOne[0],arrayTwo[0]};
		int smallestDiff = Integer.MAX_VALUE;

		
		while(pointerOne < arrayOne.length && pointerTwo < arrayTwo.length) {
			int valueOne = arrayOne[pointerOne];
			int valueTwo = arrayTwo[pointerTwo];
			int diff = Math.abs(valueOne-valueTwo);
			
			if(diff < smallestDiff) {
				smallestDiff =diff;
				results = new int[] {valueOne , valueTwo};
			}
			if(valueOne < valueTwo) 
				pointerOne++;
			else
				pointerTwo++;
		}
		return results;
		
	}
}
