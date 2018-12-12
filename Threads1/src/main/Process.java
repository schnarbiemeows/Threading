package main;

public class Process extends Thread {

	public void run() {
		System.out.println("running!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
