import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dylan
 *
 */
public class App2 {

	/**
	 * tutorial 12: Semaphores
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
