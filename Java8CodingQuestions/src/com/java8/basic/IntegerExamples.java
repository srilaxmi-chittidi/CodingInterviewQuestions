package com.java8.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class IntegerExamples {

	public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87, 32, 95, 14, 56);
        
        //Printing EVen numbers and Odd Numbers
        seperateEvenOdd(listOfIntegers);
        
        //Remove Duplicate numbers from list
        removeDupsFromList(listOfIntegers);
        
        //Max element in list
        maxEle(listOfIntegers);
        
        //Min Max ele without using max / min
        minMaxWithout(listOfIntegers);
	}

	public static void seperateEvenOdd(List<Integer> list) {
		Map<Boolean,List<Integer>> map = list.stream()
												.collect(Collectors.partitioningBy(i->i%2==0));
		System.out.println("...Even Nums and Odd Nums...");

		for(Entry<Boolean,List<Integer>> entry : map.entrySet()) {
			System.out.println("..............");
			System.out.println((entry.getKey()) ? "Even Numbers " : "Odd Numbers");
			System.out.println("..............");
			
			List<Integer> values = entry.getValue();
			values.stream().forEach(System.out::println);
			
		}
	}
	public static void removeDupsFromList(List<Integer> list) {
		List<Integer> result = list.stream().distinct().collect(Collectors.toList());
		System.out.println(".....Remove Dups from List......");
		result.stream().forEach(System.out::println);
		System.out.println("..............");

	}
	public static void maxEle(List<Integer> list) {
		System.out.println(".....Max element from List......");

		int max = list.stream()
			.max(Integer::compare)
			.get();
		System.out.println("max : "+max);
		System.out.println("..............");

	}
	public static void minMaxWithout(List<Integer> list) {
		System.out.println(".....Min Max element of List......");
		list.stream()
			.reduce(Integer.MAX_VALUE, (a,b)->Integer.max(a, b));
		list.stream()
			.reduce(Integer.MIN_VALUE, (a,b)->Integer.min(a, b));
		list.stream()
			.reduce(Integer::max)
			.get();
		
		list.stream()
			.reduce(Integer::min)
			.get();
		
		System.out.println("..............");

	}

}
