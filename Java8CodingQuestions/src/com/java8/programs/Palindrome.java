package com.java8.programs;

import java.util.stream.IntStream;

public class Palindrome {

	public static void main(String[] args) {
		isPalindrome("AVIVA");
		isPalindrome("RAMA");

	}
	public static void isPalindrome(String str) {
		boolean isPalind = IntStream.range(0, str.length()/2)
				.noneMatch(i->str.charAt(i) != str.charAt(str.length()-i-1));
		System.out.println(isPalind);
	}
}
