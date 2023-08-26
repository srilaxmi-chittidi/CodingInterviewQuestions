package com.java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		
		List<Employee> empList = EmployeeRepo.employeeDB();
		mapOps();
		collectOps(empList);
		filterOps();
		findFirstOps();
		Employee[] empArray = convertToArray(empList);
		System.out.println(empArray.length);
		faltMapOps();
		peekOps(empList);
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
	public static void findFirstOps() {
		System.out.println("----------Find First Operation---------");
		
		Integer[] empIds = {135,124,112,123,108,107};
		
		Stream.of(empIds)
				.map(EmployeeRepo::findById)
				.filter(x->x != null)
				.filter(x->x.getSalary() >50000)
				.findFirst()
				.ifPresent(System.out::println);
	}
	public static Employee[] convertToArray(List<Employee> empList) {
		System.out.println("----------List to Array conversion---------");
		
		return empList.stream().toArray(Employee[] :: new);

	}
	public static void faltMapOps() {
		System.out.println("----------Flat Map Operation---------");
		
		List<List<String>> listOfList =Arrays.asList(
				Arrays.asList("Radha","Krishna"),
				Arrays.asList("Ram","Sita"),
				Arrays.asList("Shiva","Parvathi")
				);
		List<String> list = listOfList
				.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
	public static void peekOps(List<Employee> empList) {
		System.out.println("----------Peek Operation---------");
		
		empList.stream()
			.peek(e->e.salaryIncr(10.0))
			.collect(Collectors.toList())
			.forEach(System.out::println);;
	}
}
