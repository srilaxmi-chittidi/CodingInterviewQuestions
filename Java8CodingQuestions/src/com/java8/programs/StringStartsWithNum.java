package com.java8.programs;

import java.util.Arrays;

public class StringStartsWithNum {

	public static void main(String[] args) {
		String[] strs = new String[] {"Hi","1ser","4seda"};
		StartsWithNum(strs);

	}
	public static void StartsWithNum(String[] strs) {
		Object[] numStrs = Arrays.stream(strs)
		      .filter(x->Character.isDigit(x.charAt(0)))
		      .toArray();
		Arrays.stream(numStrs)
			  .map(x->x.toString())
		      .forEach(System.out::println);
	}
}
