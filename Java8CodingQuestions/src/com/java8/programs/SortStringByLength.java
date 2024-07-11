package com.java8.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringByLength {

	public static void main(String[] args) {
		List<String> strList =  Arrays.asList("Hi","Hello","How","a");
		List<String> list = sortedStrs(strList);
		list.stream().forEach(System.out::println);
	}

	public static List<String> sortedStrs(List<String> list){
		return list.stream()
				.sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
	}
}
