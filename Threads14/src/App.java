import java.util.Random;

/**
 * @author dylan
 *
 */
public class App {

	/**
	 * tutorial 14: interrupting Threads implementing thread interruption capability
	 * is a 2 part process: 1. you need to check for interrupted inside the thread
	 * method 2. you need to create your thread interruption condition in the method
	 * that calls the thread
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting ...");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Random random = new Random();

				for (int i = 0; i < 1E8; i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted."); // one way to check for interrupted
						break;
					}
					/*
					 * try { Thread.sleep(1); } catch (InterruptedException e) {
					 * System.out.println("Interrupted."); // another way to check for interrupted
					 * break; }
					 */
					Math.sin(random.nextDouble());
				}
			}
		});
		t1.start();
		Thread.sleep(500);
		t1.interrupt(); // this does not actually interrupt the thread, it just sets a flag
		// that needs to be checked for
		t1.join();
		System.out.println("Finished.");
	}

}
