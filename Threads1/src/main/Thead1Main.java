package main;

/**
 * @author dylan
 *
 */
public class Thead1Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		Thread thread1 = new Process();
		thread1.start();
		try {
			thread1.join();
			System.out.println("here!");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
