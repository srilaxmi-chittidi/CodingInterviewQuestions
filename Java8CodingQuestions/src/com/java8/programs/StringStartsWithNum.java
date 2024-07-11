package com.java8.programs;

import java.util.Arrays;
import java.util.List;

public class StringStartsWithNum {

	public static void main(String[] args) {
		String[] strs = new String[] {"Hi","1ser","4seda"};
		StartsWithNum(strs);
		List<Integer> list = Arrays.asList(1,34,23,13,100);
		StartsWith1(list);
		
	}
	public static void StartsWithNum(String[] strs) {
		Object[] numStrs = Arrays.stream(strs)
		      .filter(x->Character.isDigit(x.charAt(0)))
		      .toArray();
		Arrays.stream(numStrs)
			  .map(x->x.toString())
		      .forEach(System.out::println);
	}
	
	public static void StartsWith1(List<Integer> intList) {
		intList.stream()
				.map(x->x+"")
				.filter(x->x.startsWith("1"))
				.forEach(x->System.out.println(x+" "));
	}
}
