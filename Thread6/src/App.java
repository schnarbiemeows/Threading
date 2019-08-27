import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dylan
 *
 */
class Processor implements Runnable {

	private CountDownLatch latch;

	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Started.");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		latch.countDown();
	}
}

/**
 * @author dylan
 *
 */
public class App {

	/**
	 * tutorial 6: countdown latches
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// CountDownLatch is thread safe: no need for synchronized keyword
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			System.out.println("submitting.");
			executor.submit(new Processor(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("Completed.");
	}

}
