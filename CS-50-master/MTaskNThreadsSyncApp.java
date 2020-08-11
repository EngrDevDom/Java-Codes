package com.practice;

/**
 * Print numbers from 1 to 100 with 2 or more threads
 * @author sada
 *
 */
public class MTaskNThreadsSyncApp {

	static int numThreads = 5;
	static Object lock;

	
	public static void main(String[] args) {
		lock = new Object();
		Thread t;
		for(int i=1;i<=numThreads;i++){
			t = new Thread(new MyRunnableMN(i));
			t.setName("thread-id:"+i);
			t.start();
		}
	}
}

class MyRunnableMN implements Runnable {

	int id;
	static volatile int counter=1;


	MyRunnableMN(int id){
		this.id = id;
	}
	@Override
	public void run() {
		synchronized (MTaskNThreadsSyncApp.lock) {
			// limit set to 20 
			while(counter<20){
				if(counter == id ||
						counter%MTaskNThreadsSyncApp.numThreads==id ||
						(counter%id==0 && MTaskNThreadsSyncApp.numThreads==id)){
					System.out.println(Thread.currentThread().getName()+" "+counter);
					counter++;
					MTaskNThreadsSyncApp.lock.notifyAll();

				} else
					try {
						MTaskNThreadsSyncApp.lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}
