package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ComparisionOperations {

	public static void main(String[] args) {
		
		List<Employee> empList = EmployeeRepo.employeeDB();
		sortedEmps(empList);
		minByAge(empList);
		maxBySalary(empList);
		allMatchDemo();
		anyMatchDemo();
		noneMatchDemo();
	}
	
	public static void sortedEmps(List<Employee> empList) {
		System.out.println("------------Sorted Demo-----------");		

		List<Employee> emps = empList.stream()
				.sorted((e1,e2)->e1.getEmpName().compareTo(e2.getEmpName()))
				.collect(Collectors.toList());
		emps.stream().forEach(System.out::println);
	}
	
	public static void minByAge(List<Employee> empList) {
		System.out.println("------------Minimum Demo-----------");		

		Employee emp = empList.stream()
				.min((e1,e2)->e1.getAge()-e2.getAge())
				.orElseThrow(NoSuchElementException::new);
		
		System.out.println(emp.getAge());
	}
	public static void maxBySalary(List<Employee> empList) {
		System.out.println("------------Maximum Demo-----------");		

		Employee emp = empList.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException :: new);
		System.out.println(emp.getSalary());
	}
	public static void distinctNums() {
		
		System.out.println("------------Distinct Demo-----------");		
		List<Integer> list = Arrays.asList(2,5,4,3,4,3,3);
		
		List<Integer> result = list.stream()
			.distinct()
			.collect(Collectors.toList());
		result.stream().forEach(System.out::println);
	}
	public static void allMatchDemo() {
		System.out.println("------------All Match Demo-----------");	
		
		List<Integer> list = Arrays.asList(2,4,8,6);
		
		boolean isEven = list.stream()
			.allMatch(i->i%2==0);
		System.out.println("Is this list all even ? "+isEven);
	}
	public static void anyMatchDemo() {
		System.out.println("------------Any Match Demo-----------");	
		List<Integer> list = Arrays.asList(2,4,5,6);
		boolean isOdd = list.stream()
				.anyMatch(i->i%2==0);
		System.out.println("Is this list anyone odd ? "+isOdd);
	}
	public static void noneMatchDemo() {
		System.out.println("------------None Match Demo-----------");
		List<Integer> list = Arrays.asList(2,4,5,7);
		boolean noneOdd = list.stream()
				.noneMatch(i->i%3==0);
		
		System.out.println("Is this list none match ? "+noneOdd);
	}
}
