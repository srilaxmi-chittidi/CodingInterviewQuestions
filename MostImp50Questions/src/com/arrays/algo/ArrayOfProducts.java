package com.arrays.algo;

import java.util.Arrays;

public class ArrayOfProducts {

	public static void main(String[] args) {
		int[] result = arrayOfProducts(new int[] {5,1,4,2});
		Arrays.stream(result).forEach(x->System.out.println(x+" "));
	}
	 public static int[] arrayOfProducts(int[] array) {

	    int totalProduct = 1;
	    int[] result = new int[array.length];

	    totalProduct = Arrays.stream(array).reduce((x,y)->x*y).getAsInt();
	    for(int i=0;i<array.length;i++){
		      result[i] = totalProduct / array[i];
		}
	    
	    return result;
	}
}
