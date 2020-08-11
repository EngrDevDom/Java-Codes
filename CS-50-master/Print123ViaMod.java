package com.sync.three.threads;

public class Print123ViaMod {

	static int NUM_TH = 5;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new My123Runnable(0));
		Thread t2 = new Thread(new My123Runnable(1));
		Thread t3 = new Thread(new My123Runnable(2));
		Thread t4 = new Thread(new My123Runnable(3));
		Thread t5 = new Thread(new My123Runnable(4));
	
		t5.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class My123Runnable implements Runnable{

	int id;
	public My123Runnable(int id) {
		this.id = id;
	}
	
	static Object lock = new Object();
	static volatile int cnt = 0;
	@Override
	public void run() {
		while(true){
			synchronized (lock) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(cnt%Print123ViaMod.NUM_TH== this.id){
					System.out.print(" "+(this.id+1));
					cnt++;
					if(cnt>Print123ViaMod.NUM_TH)
						cnt=1;
					lock.notifyAll();
				} else
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
} 
