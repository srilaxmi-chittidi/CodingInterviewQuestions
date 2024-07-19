package com.multithreading.questions;

import java.util.stream.IntStream;

public class PrintingAlphNum {

	public static void main(String[] args) {
		
		//traditionalApproach();
		java8Approach();
	}

	public static void java8Approach() {
		
		Runnable r1 = ()-> {
			IntStream.range(0, 10).forEach(System.out::print);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable r2 = ()-> {
			char c ='A';
			IntStream.range(0, 10).forEach(x->System.out.print((char)(c+x)+" "));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void traditionalApproach() {
	Thread t1 = new Thread(new printAlph());
		
		Thread t2 = new Thread(new printNumb());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
class printAlph implements Runnable{
	
	@Override
	public void run() {
		char c = 'a';
		for(int i=0;i<10;i++) {
			System.out.print((char)(c+i)+" ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class printNumb implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}