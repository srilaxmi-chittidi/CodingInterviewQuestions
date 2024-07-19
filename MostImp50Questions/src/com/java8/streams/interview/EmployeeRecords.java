package com.java8.streams.interview;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRecords {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(101,"Raju",58,"male",580000,1998,"Admin"));
		empList.add(new Employee(103,"Rama",48,"male",680000,2000,"Admin"));
		empList.add(new Employee(121,"Eswar",28,"male",320000,2010,"IT"));
		empList.add(new Employee(122,"Swetha",52,"female",580000,1998,"HR"));
		empList.add(new Employee(114,"Chandra",54,"male",570000,1996,"HR"));
		empList.add(new Employee(104,"Swapna",32,"female",980000,2008,"Admin"));
		empList.add(new Employee(135,"Abarna",23,"female",680000,2020,"IT"));
		empList.add(new Employee(124,"Pradeep",38,"male",360000,2012,"Sales"));
		empList.add(new Employee(112,"Leela",36,"female",470000,2006,"HR"));
		empList.add(new Employee(123,"Swami",29,"male",660000,2018,"Sales"));
		empList.add(new Employee(108,"Durga",27,"female",860000,2016,"IT"));
		empList.add(new Employee(107,"Raghu",42,"male",480000,1999,"HR"));
		empList.add(new Employee(115,"Murali",35,"male",530000,2009,"Admin"));
		empList.add(new Employee(116,"Karthik",25,"male",780000,1998,"IT"));
		empList.add(new Employee(125,"Lakshmi",44,"female",550000,2002,"Admin"));
		empList.add(new Employee(118,"Satish",40,"male",230000,2005,"Sales"));
		empList.add(new Employee(119,"Akshaya",30,"female",560000,2010,"IT"));
		empList.add(new Employee(120,"Ananya",28,"female",340000,2019,"HR"));
		
//		//1. Count of male and female employees
		countGenderwise(empList);
//		
//		//2. Name of all depts
//		allDeptNames(empList);
//		
//		//3. Average age of male and female employees
//		avgAgeOfMaleFemaleEmps(empList);
//		
//		//4. Highest paid employee details 
//		highestPaidEmpDetails(empList);
//		
//		//5. Emps who have joined after 2006
//		filterEmpByJoiningDate(empList);
//		
//		//6. Count emp by dept
//		empCountByDept(empList);
//		
//		//7. Average Salary of each Dept
//		avgSalaryByDept(empList);
//		
//		//8. Youngest male employee in IT dept
//		youngestMaleInIT(empList);
//		
//		//9. Most work exp employee details
//		highestExpEmp(empList);
//		
//		//10. Male and Female emp in IT dept
//		countOfMaleFemaleInIT(empList);
//		
//		//11. Average salary of male and female emp
//		avgSalofMaleFemale(empList);
//		
//		//12. Average and total salary of Org
//		avgNTotalSalInOrg(empList);
//		
//		//13. Names of emp in each department
//		empNamesByDept(empList);
//		
//		//14. Separate emp who are younger than 25 years and older than 25 years
//		empOlderNYounger(empList);
//		
//		//15. Oldest employee and his details
//		oldestEmpDet(empList);
		
//		//16. Sort multiple sequences of Employee object
//		sortedMultipleSeq(empList);
		
		//17. Statistics of Employees Age
//		ageStats(empList);
		
		//18. Get all employee names
		getAllEmpNames(empList);
	}
	private static void getAllEmpNames(List<Employee> empList) {
		String empNames =empList.stream()
				.map(Employee::getEmpName)
				.map(String::toUpperCase)
				.collect(Collectors.joining(","));
		System.out.println(empNames);
				
	}
	public static void oldestEmpDet(List<Employee> empList) {
		System.out.println("---------Oldest employee and his details   ---------");
		Optional<Employee> emp = empList.stream()
				.max(Comparator.comparing(Employee::getAge));
		System.out.println(emp.get().getEmpName());
	}
	public static void empOlderNYounger(List<Employee> empList) {
		System.out.println("---------Separate emp who are younger than 25 years and older than 25 years  ---------");

		Map<Boolean, List<Employee>> partitionByAge = empList.stream()
				.collect(Collectors.partitioningBy(e->e.getAge()>25));
		Set<Map.Entry<Boolean, List<Employee>>> entrySet = partitionByAge.entrySet();
		for(Map.Entry<Boolean, List<Employee>> e : entrySet) {
			if(e.getKey()) {
				System.out.println("Older than 25 years");
			}else {
				System.out.println("Younger than 25 years");
			}
			System.out.println("-----------------------------");
			for(Employee emp : e.getValue()) {
				System.out.println(emp.getEmpName());
			}
		}
	}
	
	public static void empNamesByDept(List<Employee> empList) {
		System.out.println("---------Names of emp in each department     ---------");

		Map<String, List<Employee>> byDept = 
				empList.stream()
		       .collect(Collectors.groupingBy(Employee::getDept));
		
		for(Map.Entry<String, List<Employee>> map : byDept.entrySet()) {
			String dept = map.getKey();
			System.out.print(dept+" : ");
			for(Employee e : map.getValue()) {
				System.out.println(e.getEmpName());
			}
		}
		
	}
	public static void avgNTotalSalInOrg(List<Employee> empList) {
		System.out.println("---------Average and total salary of Org      ---------");
		DoubleSummaryStatistics dss = empList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(dss.getAverage()+" "+dss.getSum());
	}
	public static void avgSalofMaleFemale(List<Employee> empList) {
		System.out.println("---------Average salary of male and female emp---------");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.averagingDouble(Employee::getSalary)))
				.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void countOfMaleFemaleInIT(List<Employee> empList) {
		System.out.println("--------- Most work exp employee details     ----------");
		empList.stream()
				.filter(e->e.getDept() == "IT")
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.counting()))
				.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void highestExpEmp(List<Employee> empList) {
		System.out.println("--------- Most work exp employee details     ----------");
		Employee emp = empList.stream()
				.min(Comparator.comparing(Employee::getYearOfJoining))
				.get();
		
		System.out.println(emp.getEmpName());
		
	}
	
	public static void youngestMaleInIT(List<Employee> empList) {
		System.out.println("--------- Youngest male employee in IT dept     --------");
		Optional<Employee> emp = empList.stream()
			   .filter(e->(e.getDept() == "IT" && e.getGender() == "male"))
			   .min(Comparator.comparing(Employee::getAge));
		
		System.out.println(emp.get().getEmpName());
			
		

	}
	public static void avgSalaryByDept(List<Employee> empList) {
		System.out.println("--------- Average Salary of each Dept           --------");

		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.averagingDouble(Employee::getSalary)))
				.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void empCountByDept(List<Employee> empList) {
		System.out.println("--------- Count emp by dept                     --------");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept,
						Collectors.counting()))
				.forEach((k,v)->System.out.println(k+" "+v));;

	}
	public static void filterEmpByJoiningDate(List<Employee> empList) {
		System.out.println("--------- Emps who have joined after 2006        --------");
		empList.stream()
				.filter(e->e.getYearOfJoining() > 2006)
				.collect(Collectors.toList())
				.forEach(e->System.out.println(e.getEmpName()));
	}
	
	public static void highestPaidEmpDetails(List<Employee> empList) {
		System.out.println("--------- Highest paid employee details          --------");

			String empName = empList.stream()
				.max(Comparator.comparingDouble(Employee::getSalary))
				.get()
				.getEmpName();
			System.out.println(empName);
	}
	
	public static void avgAgeOfMaleFemaleEmps(List<Employee> empList) {
		System.out.println("--------- Average age of male and female employees--------");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.averagingInt(Employee::getAge)))
				.forEach((k,v)->System.out.println(k+" "+v));
	}
	
	public static void countGenderwise(List<Employee> empList) {
		System.out.println("------------ count of male and female employees-----------");
		empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.counting()))
				.forEach((k,v)->System.out.println(k+" "+v));;
	}
	public static void allDeptNames(List<Employee> empList) {
		System.out.println("------------ Name of all depts                 -----------");
		empList.stream()
				.map(Employee::getDept)
				.distinct()
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}
	public static void sortedMultipleSeq(List<Employee> list) {
		list.stream()
		.sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getSalary))
		.collect(Collectors.groupingBy(Employee::getEmpName))
		.forEach((k,v)->System.out.println(k+" "+v));;
	}
	public static void ageStats(List<Employee> list) {
		IntSummaryStatistics stats = list.stream()	
			.map(Employee:: getAge)
			.mapToInt(x->x)
			.summaryStatistics();
		System.out.println("Max Age : "+stats.getMax()+" Min Age : "+stats.getMin()+" Sum of Age "+stats.getSum()+" "+stats.getAverage());
	}

}
class Employee{
	private long empId;
	private String empName;
	private int age;
	private String gender;
	private double salary;
	private long yearOfJoining;
	private String dept;
	public Employee(long empId, String empName, int age, String gender, double salary, long yearOfJoining, String dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.yearOfJoining = yearOfJoining;
		this.dept = dept;
	}
	public long getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public double getSalary() {
		return salary;
	}
	public long getYearOfJoining() {
		return yearOfJoining;
	}
	public String getDept() {
		return dept;
	}
	
	
}