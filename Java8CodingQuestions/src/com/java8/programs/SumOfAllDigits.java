package com.java8.programs;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigits {

	public static void main(String[] args) {
		// Sum of All Digits
		System.out.println(sumOfAllDigits(12345));
	}

	public static int sumOfAllDigits(int intValue) {
		return Stream.of(String.valueOf(intValue).split(""))
		      .collect(Collectors.summingInt(Integer::parseInt));
	}
}
