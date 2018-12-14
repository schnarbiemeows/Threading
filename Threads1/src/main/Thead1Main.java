package main;

public class Thead1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread1 = new Process();
		thread1.start();
		try {
			thread1.join();
			System.out.println("here!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
