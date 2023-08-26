package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepo {

	public static void main(String[] args) {
		System.out.println(findById(107));
	}

	public static Employee findById(int id) {
		List<Employee> empList = employeeDB();
		return empList.stream().filter(x->x.getEmpId()==id).findAny().get();
	}
	public static List<Employee> employeeDB() {
		List<Employee> empList = new ArrayList<Employee>();
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
		
		return empList;
	}

	
}
class Employee{
	private long empId;
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setYearOfJoining(long yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	private String empName;
	private int age;
	private String gender;
	private double salary;
	private long yearOfJoining;
	private String dept;
	public Employee() {
		
	}
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
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", age=" + age + ", gender=" + gender + ", salary="
				+ salary + ", yearOfJoining=" + yearOfJoining + ", dept=" + dept + "]";
	}
	public static List<Employee> salaryIncr(double p) {
		List<Employee> empList = EmployeeRepo.employeeDB();
		return empList.stream()
				.peek(x-> x.setSalary
						(x.getSalary()+(x.getSalary()*(p/100))))
				.collect(Collectors.toList());
	}
}