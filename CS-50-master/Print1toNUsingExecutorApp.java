package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * print numbers 1 to N using one or more threads using executor Framework
 * @author sada
 *
 */
public class Print1toNUsingExecutorApp {

	static final int NUM_OF_THREADS = 2;
	static final int COUNTER = 50;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
		//		ExecutorService executorService = Executors.newCachedThreadPool();//(NUM_OF_THREADS);
		for(int i=0;i<10;i++)
			executorService.execute(new NumRunnable(i));
		
		executorService.shutdown();
		while(!executorService.isTerminated()){

		}
		System.out.println("Finished all threads");
	}
}

class NumRunnable implements Runnable {

	int i;

	public NumRunnable(int i) {
		this.i= i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+": "+i);
	}

}
