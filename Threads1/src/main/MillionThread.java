package main;

/**
 * @author dylan
 *
 */
public class MillionThread implements Runnable {

	private static int count = 0;
	private Object lock = new Object();

	/**
	 * 
	 */
	public void increment() {
		synchronized (lock) {
			if (count < 1000000)
				count++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		increment();

		System.out.println("hit");
	}

}
