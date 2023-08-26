package com.java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		
		List<Employee> empList = EmployeeRepo.employeeDB();
		mapOps();
		collectOps(empList);
		filterOps();
	}

	public static void mapOps() {
		System.out.println("----------Map Operation---------");
		Integer[] empIds = {125,119};
		List<Employee> list = Stream.of(empIds)
								.map(EmployeeRepo::findById)
								.collect(Collectors.toList());
		list.stream().forEach(System.out::println);
	}
	public static void collectOps(List<Employee> empList) {
		System.out.println("----------Collect Operation---------");
		empList.stream()
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}
	public static void filterOps() {
		System.out.println("----------Filter Operation---------");

		Integer[] empIds = {125,119};

		Stream.of(empIds)
				.map(EmployeeRepo::findById)
				.filter(x->x!=null)
				.filter(x->x.getDept() == "IT")
				.forEach(System.out::println);
	}
	
}
