package com.arrays.algo;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

	public static void main(String[] args) {
		int[][] in = new int[][] {
			{1,2,3,4},
			{12,13,14,5},
			{11,16,15,6},
			{10,9,8,7}};
		int rows = in.length;
		int cols = in[0].length;
		List<Integer> out  = new ArrayList<>();

		spiralTraverse(in,0,rows-1,0,cols-1,out);
		out.stream().forEach(x->System.out.print(x+" "));

	}

	public static void spiralTraverse(int[][] inp,int startRow,int endRow,int startCol,int endCol,List<Integer> out) {
		
		if(startRow > endRow || startCol > endCol) return;
		for(int i=startCol ;i<=endCol ;i++) {
			out.add(inp[startCol][i]);
		}
		for(int i =startRow+1 ;i<= endRow;i++) {
			out.add(inp[i][endCol]);
		}
		for(int i =endCol-1;i>=startCol;i--) {
			out.add(inp[endRow][i]);
		}
		for(int i=endRow-1;i>=startRow+1;i--) {
			out.add(inp[i][startRow]);
		}
		spiralTraverse(inp, startRow+1,endRow-1,startCol+1,endCol-1,out);

	}
}
