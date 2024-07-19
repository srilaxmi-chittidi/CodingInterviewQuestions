package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreation {
	public static void main(String[] args) {
		Employee[] arrayOfEmps = {
				new Employee(101,"Raju",58,"male",580000,1998,"Admin"),
				new Employee(103,"Rama",48,"male",680000,2000,"Admin"),
				new Employee(121,"Eswar",28,"male",320000,2010,"IT")
			};
//		empStreamByArray(arrayOfEmps);
//		convertToList(arrayOfEmps);
//		byBuilder();
//		generateRandomNums();
//		evenNums();
//		mapByFirstChar(arrayOfEmps);
//		incrSalAndSum(arrayOfEmps);
		mappingByName(arrayOfEmps);
//		evenNoddNums();
//		salarySum(arrayOfEmps);
//		avgSalary(arrayOfEmps);
	}
	public static void avgSalary(Employee[] arrayOfEmps) {
		double avgSal = Arrays.stream(arrayOfEmps)
				.mapToDouble(Employee::getSalary)
				.average()
				.orElseThrow(NoSuchElementException::new);
		System.out.println(avgSal);
		
	}
	public static void salarySum(Employee[] arrayOfEmps) {
		double sum = Arrays.stream(arrayOfEmps)
				.map(Employee::getSalary)
				.reduce(0.0,Double::sum);
		System.out.println(sum);
	}
	public static void evenNoddNums() {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Map<Boolean,List<Integer>> map = intList.stream()
				.collect(Collectors.partitioningBy(e->e%2 == 0));
				
		map.forEach((k,v) -> System.out.println(k+" "+v));				
		
	}
	public static void mappingByName(Employee[] arrayOfEmps) {
			Arrays.stream(arrayOfEmps)
				.collect(Collectors.groupingBy(e->new Character(e.getEmpName().charAt(0)),
						Collectors.mapping(Employee::getEmpName, Collectors.toList())))
				.forEach((k,v)-> System.out.println(k+" "+v));;;
		
	}
	
	public static void incrSalAndSum(Employee[] arrayOfEmps) {
		
		List<Employee> empList = Arrays.asList(arrayOfEmps);
		double sum = empList.stream().collect(Collectors.reducing(
				        0.0, e -> e.getSalary() * 5 / 100, (s1, s2) -> s1 + s2));
		System.out.println(sum);
	}
	public static void mapByFirstChar(Employee[] arrayOfEmps) {
		
		 Map<Character, List<Employee>> groupByAlphabet = Arrays.stream(arrayOfEmps)
				.collect(Collectors.groupingBy(e->new Character(e.getEmpName().charAt(0))));
			
		 groupByAlphabet.forEach((k,v)->System.out.println(k+" "+v));
		
	}
	public static void evenNums() {
		
		Stream.iterate(2, i->i*2)
				.limit(5)
				.forEach(System.out::println);;
		
	}
	public static void generateRandomNums() {
		Stream.generate(Math::random)
				.limit(5)
				.forEach(System.out::println);
	}

	public static void empStreamByArray(Employee[] arrayOfEmps) {
		Arrays.stream(arrayOfEmps).forEach(System.out::println);
	}
	
	public static void convertToList(Employee[] arrayOfEmps) {
		List<Employee> list = Arrays.asList(arrayOfEmps);
		list.stream().forEach(System.out::println);
	}
	public static void byBuilder() {
		Stream.Builder<Employee> builder = Stream.builder();
		builder.accept(new Employee(125,"Lakshmi",44,"female",550000,2002,"Admin"));
		builder.accept(new Employee(118,"Satish",40,"male",230000,2005,"Sales"));
		builder.accept(new Employee(119,"Akshaya",30,"female",560000,2010,"IT"));
		builder.accept(new Employee(120,"Ananya",28,"female",340000,2019,"HR"));
		
		Stream<Employee> empStream = builder.build();
		empStream.forEach(System.out::println);
	}
	
	
}
