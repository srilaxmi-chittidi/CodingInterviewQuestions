package com.multithreading.questions;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {
	
	public static void main(String args[]) {
		CompletableFuture<Void> numbers = CompletableFuture.runAsync(()->{
			for(int i=0;i<=5;i++) {
				System.out.print(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		CompletableFuture<Void> chars = CompletableFuture.runAsync(() -> {
			for(char c='a';c<'e';c++) {
				System.out.print(c);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		CompletableFuture<Void> combinedFuture = numbers.thenCombine(chars, (void1,void2)->null);
		
		combinedFuture.join();
		
	}
}
