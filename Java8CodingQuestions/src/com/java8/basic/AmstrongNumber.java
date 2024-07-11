package com.java8.basic;

public class AmstrongNumber {

	public static void main(String[] args) {
		isAmstrong(371);
		isAmstrong(123);
	}
	public static void isAmstrong(int num) {
		String str = String.valueOf(num);
		int len = str.length();
		int sum = 
				str.chars()
					.map(ch->Character.digit(ch, 10))
					.map(digit-> (int)Math.pow(digit, len))
					.sum();
		System.out.println(sum == num);
	}
	
}
