package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
//		countOfEachChar("Ananya");
//		findAllDuplicates("Ananya");
//		findUniqueElements("Ananya");
//		findFirstUniqueElement("Ananya");
//		findSecondHighestNumber(new int[] {5,9,11,2,8,21,1});
//		longestStrInArray(new String[] {"java","techie","springboot","microservices"});
//		findEleStartsWith1(new int[] {5,9,11,2,8,21,1});
//		stringJoinerExample(new String[] {"1","2","3","4"});
//		skipLimitExample();
//		collectExample();
//		OptionalDemo();
//		countDemo();
//		concurrentHashMapDemo();
//		copyOnWriteArrayListDemo();
//		sumOfAllIntegers();
//		avgSumOfAllIntegers();
//		numSquareAverage();
//		duplicateNumbers();
//		maxNminNumbers();
//		ascDescNumbers();
//		removeWhiteSpaces("Hello World!! ");
//		removeAdditionalWhiteSpaces("Hello           World!! ");
//		lexigraphical(21);
	}
	public static void removeAdditionalWhiteSpaces(String str) {
		
		List<String> list = Arrays.stream(str.split("\\s+")).collect(Collectors.toList());
		String st = list.stream().collect(Collectors.joining(" "));
		list.forEach(System.out::println);
		System.out.println(st);
	}
	public static void removeWhiteSpaces(String str) {

		String output = str.chars()
			.filter(c-> !Character.isWhitespace(c))
			.mapToObj(c -> String.valueOf((char)c))
			.collect(Collectors.joining());
		System.out.println(output);
	}

	public static void ascDescNumbers() {
		List<Integer> list = Arrays.asList(1,3,10,20,30,15,1,13,1,2,2,10,30,19,3);
		list.stream()
			.sorted()
			.collect(Collectors.toList())
			.forEach(System.out::println);;
		list.stream()
			.sorted(Collections.reverseOrder())
			.collect(Collectors.toList())
			.forEach(System.out::println);;
	}
	public static void maxNminNumbers() {
		List<Integer> list = Arrays.asList(1,3,10,20,30,15,1,13,1,2,2,10,30,19,3);
		int maxVal = list.stream()
			.max(Comparator.comparing(Integer::valueOf))
			.get();
		int minVal = list.stream()
				.min(Comparator.comparing(Integer::valueOf))
				.get();
		System.out.println(maxVal+" "+minVal);
	}
	public static void duplicateNumbers() {
		List<Integer> list = Arrays.asList(1,3,10,20,30,15,1,13,1,2,2,10,30,19,3);
		list.stream()
			.filter(x->Collections.frequency(list, x)>1)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
	}
	public static void numSquareAverage() {
		List<Integer> list = Arrays.asList(1,10,20,30,15);
		double d = list.stream()
			.mapToInt(e->e)
			.map(e->e*e)
			.filter(e->e>100)
			.average()
			.getAsDouble();
		System.out.println(d);

	}
	public static void avgSumOfAllIntegers() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		double avg = list.stream().mapToDouble(x->x).average().getAsDouble();
		System.out.println(avg);
	}
	public static void sumOfAllIntegers() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		OptionalInt sum  = list.stream().mapToInt(x->x).reduce((x,y)->x+y);
		System.out.println(sum);
	}
	public static void countOfEachChar(String str) {
		
		Map<String,Long> map = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.forEach((k,v) -> System.out.println(k+" "+v));
		
	}
	public static void findAllDuplicates(String str) {
		Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(x -> x.getValue()>1)
				.forEach(System.out::println);
	}
	public static void findUniqueElements(String str) {
		Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(x->x.getValue()==1)
				.forEach(System.out::println);
		
	}
	public static void findFirstUniqueElement(String str) {
		String key = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet()
				.stream()
				.filter(x->x.getValue()==1)
				.findFirst()
				.get()
				.getKey();
		
		System.out.println(key);
	}
	public static void findSecondHighestNumber(int[] nums) {
		int secondHighest = Arrays.stream(nums)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		System.out.println(secondHighest);
	}
	public static void longestStrInArray(String[] strArry) {
		String longestStr = Arrays.stream(strArry)
				.reduce((word1,word2) ->  word1.length()>word2.length() ? word1 :word2)
				.get();
		System.out.println(longestStr);
	}
	
	public static void findEleStartsWith1(int[] intArr) {
		
		Arrays.stream(intArr)
				.boxed()
				.map(x->x+"")
				.filter(x->x.startsWith("1"))
				.forEach(System.out::println);
	}
	public static void stringJoinerExample(String[] strArr) {
		//String results = String.join("-",strArr);
		String results = Arrays.stream(strArr)
				.collect(Collectors.joining(","))
				.toString();
		System.out.println(results);
	}
	public static void skipLimitExample() {
		IntStream.rangeClosed(1, 10)
			.skip(2)
			.limit(6)
			.forEach(System.out::println);
	}
	
	public static void toArrayExample() {
		List<Integer> list = Arrays.asList(1,2,3,4);
		Object[] arr = list.stream().toArray();
	}
	public static void collectExample() {
//		Stream.of(1,2,3,4)
//		       .map(x->x*2)
//			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//			.forEach((k,v)->System.out.println(k+" "+v));;
		Stream.of(1,2,3,4)
		       .map(x->x*2)
		       .collect(Collectors.toList())
		       .parallelStream()
			   .forEachOrdered(System.out::println);
		
	}
	
	public static void OptionalDemo() {
		List<Integer> list = Arrays.asList(12,34,5,23,9);
		Optional<Integer> output = list.stream().reduce((x,y) -> x*y);
		output.ifPresentOrElse(System.out::println, null);
	}
	public static void countDemo() {
		List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10, 12);
		long total = list.stream().collect(Collectors.counting());
		System.out.println(total);
	}
	
	public static void concurrentHashMapDemo(){
		
		Map<String,String> map = new HashMap<>();
		map.put("One" , "1");
		map.put("Two" , "2");
		map.put("Three" , "3");
		map.put("Four" , "4");
		
		Map<String,String> synchronizedMap = Collections.synchronizedMap(map);
		
//		for(Map.Entry<String,String> entry: map1.entrySet()) {
//			System.out.println(entry.getKey()+" "+entry.getValue());
//			map1.put("Five", "5");
//		}
		 Iterator<Entry<String, String>> iterator = synchronizedMap.entrySet().iterator();
		    while (iterator.hasNext()) {
		        synchronizedMap.put("3", "Modification");
		        iterator.next();
		    }
		System.out.println("-------------");
	//	map1.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void copyOnWriteArrayListDemo() {
		List<String> list = new CopyOnWriteArrayList<>();
		
		list.add("one"); list.add("two"); list.add("three"); list.add("four");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			list.add("five");
		}
	}
	
	
}
