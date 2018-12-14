package main;

public class MillionThread implements Runnable {

	private int count = 0;
	private Object lock = new Object();
	
	public void increment() {
		synchronized(lock) {
			count++;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(count<1000000) {
			increment();
		}
		if(count==1000000) {
			System.out.println("hit");
		}
	}

}
