package com.java8.programs;

import java.util.Arrays;
import java.util.List;

public class CommonElementsBetweenArrays {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Hi","Hello","How","you");
		List<String> list2 = Arrays.asList("Hi","Good","How","Morning");
		commonEle(list1,list2);
		
	}
	public static void commonEle(List<String> list1,List<String> list2) {
		list1.stream()
		     .filter(list2::contains)
		     .forEach(System.out::println);
	}

}
