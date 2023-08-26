package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {
	public static void main(String[] args) {
		Employee[] arrayOfEmps = {
				new Employee(101,"Raju",58,"male",580000,1998,"Admin"),
				new Employee(103,"Rama",48,"male",680000,2000,"Admin"),
				new Employee(121,"Eswar",28,"male",320000,2010,"IT")
			};
		empStreamByArray(arrayOfEmps);
		convertToList(arrayOfEmps);
		byBuilder();
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
