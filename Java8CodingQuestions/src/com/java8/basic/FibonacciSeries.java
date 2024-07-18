package com.java8.basic;

import java.util.stream.Stream;

public class FibonacciSeries {

	public static void main(String[] args) {
		fibonacci(5);
	}
	public static void fibonacci(int n) {
		Stream.iterate(new int[] {0,1}, f-> new int[] {f[1],f[0]+f[1]})
				.limit(n)
				.map(f->f[0])
				.forEach(x->System.out.println(x+" "));
	}
}
