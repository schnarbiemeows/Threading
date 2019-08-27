package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dylan
 *
 */
public class CountToMillionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long begin = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 4; i++) {
			executor.submit(new MillionThread());
		}
		executor.shutdown();
		try {
			System.out.println("gathering = ");
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time = " + (end - begin));
	}

}
