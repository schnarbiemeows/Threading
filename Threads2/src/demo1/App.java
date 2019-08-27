package demo1;

import java.util.Scanner;

/**
 * tutorial 2: basic Thread synchronization purpose of the volatile keyword: on
 * some systems, in order to optimize performance, the OS or JVM assumes that
 * the local data in this thread's object will never be changed by other
 * threads(like the main method thread below is calling shutdown to change the
 * running field's value), so it caches it. therefore, unless the enclosing
 * thread changes the thread's data objects, it assumes that it will have the
 * same value(i.e, the running variable will always be true), and will never
 * re-check it's value unless it changes it directly. so, we have to use this
 * volatile keyword which forces the thread to recheck the value of running
 * every time this will ensure that our little program will work on all systems!
 * 
 * @author dylan
 *
 */
class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");
			;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			;
		}
	}

	public void shutdown() {
		running = false;
	}
}

/**
 * @author dylan
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Processor proc1 = new Processor();

		proc1.start();

		System.out.println("Press return to stop ...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		proc1.shutdown();
	}

}
