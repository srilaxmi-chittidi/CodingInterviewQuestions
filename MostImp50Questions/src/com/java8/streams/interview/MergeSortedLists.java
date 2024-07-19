package com.java8.streams.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedLists {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(12,4,2,10);
		List<Integer> list2 = Arrays.asList(10,8,4,3);
		
		List<Integer> list = 
				Stream.of(list1,list2)
				.flatMap(List::stream)
				.sorted()
				.collect(Collectors.toList());
		list.stream().forEach(x->System.out.print(x+" "));

	}

}
