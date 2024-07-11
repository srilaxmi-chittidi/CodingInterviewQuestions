package com.java8.basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeOfPersonInYears {

	public static void main(String[] args) {
		LocalDate dob = LocalDate.of(1982, 05, 17);
		ageOfPerson(dob);
	}
	public static void ageOfPerson(LocalDate dob) {
		LocalDate today = LocalDate.now();
		long years = ChronoUnit.YEARS.between(dob, today);
		System.out.println(years);
	}
}
