package com.multithreading.questions;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class PrintEvenOddByComFuture {

//	private static Object object = new Object();
//	private static IntPredicate evenNumber = e->e%2 ==0;
//	private static IntPredicate oddNumber = e->e%2 !=0;
//	
//	public static void main(String[] args) throws InterruptedException {
//		CompletableFuture.runAsync(() -> PrintEvenOddByComFuture.printNumber(evenNumber));
//		CompletableFuture.runAsync(() -> PrintEvenOddByComFuture.printNumber(oddNumber));
//		Thread.sleep(100);
//	}
//
//	public static void printNumber(IntPredicate condition) {
//		IntStream.range(0, 10).forEach(PrintEvenOddByComFuture::execute);
//	}
//	public static void execute(int i) {
//		synchronized (object) {
//			try {
//				System.out.println(Thread.currentThread().getName()+" : "+i);
//				object.notify();
//				object.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void main(String[] args) {
		CompletableFuture<Void> even = CompletableFuture.runAsync(()->{
			IntStream.range(0, 10).filter(e->e%2==0).forEach(x->System.out.println("Even : "+x));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		CompletableFuture<Void> odd = CompletableFuture.runAsync(() -> {
			IntStream.range(0, 10).filter(e->e%2!=0).forEach(x->System.out.println("Odd : "+x));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		CompletableFuture<Void> combinedResult = even.thenCombine(odd, (void1,void2)->null);
		combinedResult.join();
	}
}
