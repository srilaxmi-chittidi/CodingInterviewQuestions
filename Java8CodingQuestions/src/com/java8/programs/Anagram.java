package com.java8.programs;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("repaid","diaper"));
		System.out.println(isAnagram("out","town"));
	}

	public static boolean isAnagram(String s1,String s2) {
		String str1 = Stream.of(s1.split(""))
							.map(String::toUpperCase)
							.sorted()
							.collect(Collectors.joining());
		String str2 = Stream.of(s2.split(""))
							.map(String::toUpperCase)
				            .sorted()
				            .collect(Collectors.joining());
		return str1.equals(str2);
	}
}
