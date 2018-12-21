package main;

public class MillionThread implements Runnable {

	private static int count = 0;
	private Object lock = new Object();
	
	public void increment() {
		synchronized(lock) {
			if(count<1000000)
			count++;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		increment();
		
		System.out.println("hit");
	}

}
