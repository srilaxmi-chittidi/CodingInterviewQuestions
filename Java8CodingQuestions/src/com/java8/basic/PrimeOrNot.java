package com.java8.basic;

import java.util.stream.IntStream;

public class PrimeOrNot {

	public static void main(String[] args) {
		isPrime(11);
	}

	public static void isPrime(int num) {
		if(num==0 || num==1) System.out.println(false);
		if(num == 2) System.out.println(true);
		boolean isPrime = IntStream.rangeClosed(2, num/2)
				.noneMatch(x->num%x==0);
		System.out.println("Is Prime ? : "+isPrime);
	}
}
