package com.arrays.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] inputArr = {{1,2},{3,5},{4,7},{6,8},{9,10}};
		int[][] results=mergeIntervals(inputArr);
		Arrays.stream(results)
			.forEach(y->System.out.println("["+y[0]+" "+y[1]+"]"));
	}

	public static int[][] mergeIntervals(int[][] inputArr) {
		
		List<int[]> merged = new ArrayList<>();
		int[][] sorted  = inputArr.clone();
		Arrays.sort(sorted,(a,b)-> Integer.compare(a[0],b[0]));
		merged.add(sorted[0]);
		int[] current = sorted[0];
		for(int[] next : sorted) {
			int currentEnd = current[1];
			int nextStart = next[0];
			int nextEnd = next[1];
			
			if(currentEnd > nextStart) {
				current[1] = Math.max(currentEnd, nextEnd);
			}else {
				current = next;
				merged.add(current);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
