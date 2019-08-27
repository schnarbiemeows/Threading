import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dylan
 *
 */
class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Starting: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		System.out.println("Completed: " + id);
	}
}

/**
 * @author dylan
 *
 */
public class App {

	/**
	 * tutorial 5: thread pools
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// the advantage of using these thread pools is that, since threads have a lot
		// of overhead
		// associated with them, you canlimit the # of threads running at a given time
		// so as to
		// not bogg down the system
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown(); // not sure what this does

		System.out.println("All tasks submitted.");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("All tasks completed.");

		/*
		 * output is: All tasks submitted. Starting: 0 Starting: 1 Completed: 0
		 * Starting: 2 Completed: 1 Starting: 3 Completed: 2 Starting: 4 Completed: 3
		 * Completed: 4 All tasks completed.
		 * 
		 * - so it can only use 2 threads to perform the 5 submitted thread tasks, so it
		 * has to finish one - before it can start the next one
		 */

	}

}
