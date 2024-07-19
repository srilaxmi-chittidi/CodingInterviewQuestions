package com.arrays.algo;

public class BestSeat {

	public static void main(String[] args) {
		System.out.println(bestSeat(new int[] {1,0,0,0,1}));
	}

	public static int bestSeat(int[] rows) {
		
		if(rows.length < 5) return -1;
		int left = 0;
		int right = 0;
		while(left < rows.length) {
			right = left+1;
			if(rows[left] == 0 && rows[right] ==0 && rows[right+1]==0) {
				return right; 
			}else {
				left = left+1;
				right = right+1;
			}
		}
		
		return -1;
	}
}
