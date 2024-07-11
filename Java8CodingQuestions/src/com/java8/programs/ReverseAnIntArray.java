package com.java8.programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseAnIntArray {

	public static void main(String[] args) {
		reverseIntArray(new int[] {1,2,3,4,5});
	}
	
	public static void reverseIntArray(int[] array) {
		int len = array.length;
		int[] rev = IntStream.rangeClosed(1, len)
				 .map(i->array[len-i])
				 .toArray();
		Arrays.stream(rev).forEach(System.out::println);
	}

}
