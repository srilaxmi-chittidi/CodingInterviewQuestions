package com.java8.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeAndSorted {

	public static void main(String[] args) {
		int[] arr1 = new int[] {23,12,45,32,2};
		int[] arr2 = new int[] {46,32,15,52,4};
		mergeUnsortedIntoSorted(arr1,arr2);
		System.out.println("-------------");
		List<Integer> list1 = Arrays.asList(23,12,45,32,2);
		List<Integer> list2 = Arrays.asList(46,32,15,52,4);
		mergeUnsortedIntoSortedList(list1,list2);
		System.out.println("-------------");
		int[] arr3 = new int[] {23,12,46,32,2};
		int[] arr4 = new int[] {46,2,15,52,4};
		mergeUnsortedIntoSortedUnique(arr3,arr4);
	}
	public static void mergeUnsortedIntoSorted(int[] arr1,int[] arr2) {
		int[] arr =IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2))
		         .sorted()
		         .toArray();
		
		Arrays.stream(arr).forEach(System.out::println); 
	}
	public static void mergeUnsortedIntoSortedList(List<Integer> list1, List<Integer> list2) {
		
		List<Integer> list =Stream.of(list1,list2)
				.flatMap(x->x.stream())
				.sorted()
				.collect(Collectors.toList());
		
		
		list.stream().forEach(System.out::println);
	}
	public static void mergeUnsortedIntoSortedUnique(int[] arr1,int[] arr2) {
		int[] arr =IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2))
		         .sorted()
		         .distinct()		         
		         .toArray();
		
		Arrays.stream(arr).forEach(System.out::println); 
	}

}
