package com.java8.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DupEleOfArray {

	public static void main(String[] args) {
		int[] array = new int[] {23,12,45,23,45,34};
		dupEle(array);
	}
	public static void dupEle(int[] intArray) {
		Set<Integer> set = new HashSet<>();
		Arrays.stream(intArray)
		      .filter(i->!set.add(i))
		      .forEach(System.out::println);
	}
}
