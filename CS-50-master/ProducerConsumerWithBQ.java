package com.producer.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Producer/Consumer Implementation via BlockingQueue
 * @author sada
 *
 */
public class ProducerConsumerWithBQ {

	public static void main(String[] args) {

		BlockingQueue blockingQueue = new LinkedBlockingQueue();

		Thread produer = new Thread(new MyProducerRunnable(blockingQueue), "producerTh");
		Thread consumer = new Thread(new MyConsumerRunnable(blockingQueue), "consumerTh");

		produer.start();
		consumer.start();
	}
}

class MyProducerRunnable implements Runnable {

	BlockingQueue blockingQueue;

	public MyProducerRunnable(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
			try {
				System.out.println(Thread.currentThread().getName()+ " produced: "+i);
				blockingQueue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}


class MyConsumerRunnable implements Runnable {

	BlockingQueue blockingQueue;

	public MyConsumerRunnable(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		while(true){

			try {
				i = (int)blockingQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" consumed: "+i);
		}
	}
}
