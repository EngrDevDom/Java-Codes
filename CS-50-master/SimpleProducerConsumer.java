package com.producer.consumer;

import java.util.Random;
import java.util.Vector;

/**
 *  Simple Producer Consumer implementation
 *  via Wait, Notify 
 * @author sada
 *
 */
public class SimpleProducerConsumer {

	private static final int LIMIT = 4;

	public static void main(String[] args) {
		Vector sharedQ = new Vector(LIMIT);

		Thread producerTh = new Thread(new MyPCRunnable(sharedQ,LIMIT), "producer");
		Thread consumerTh = new Thread(new MyPCRunnable(sharedQ,LIMIT), "consumer");

		producerTh.start();
		consumerTh.start();

	}

}

class MyPCRunnable implements Runnable {


	Vector sharedQ;
	int limit;

	public MyPCRunnable(Vector sharedQ, int limit) {
		this.sharedQ = sharedQ;
		this.limit = limit;
	}

	@Override
	public void run() {
		while(true){
			synchronized (sharedQ) {
				if(Thread.currentThread().getName().equalsIgnoreCase("producer"))
					produce(sharedQ);
				else if(Thread.currentThread().getName().equalsIgnoreCase("consumer"))
					consume(sharedQ);
			}
		}
	}

	private void consume(Vector sharedQ2) {
		synchronized (sharedQ2) {
			if(sharedQ2.size()==0)
				try {
					sharedQ2.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object obj = sharedQ2.remove(sharedQ2.size()-1);
				System.out.println("consumed: "+obj);
				sharedQ2.notify();
			}
		}
	}

	private void produce(Vector sharedQ2) {
		synchronized (sharedQ2) {

			if(sharedQ2.size()==limit)
				try {
					sharedQ2.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sharedQ2.add(new Random().nextInt(100));
				System.out.println("produced: "+sharedQ2.toString());
				sharedQ2.notify();
			}

		}
	}

}
