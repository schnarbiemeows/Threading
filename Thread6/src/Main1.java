import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dylan
 *
 */
public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(4);
		CommonObj obj = new CommonObj();
		Processor1 pr1 = new Processor1(cdl, obj);
		Processor2 pr2 = new Processor2(cdl, obj);
		Processor3 pr3 = new Processor3(cdl, obj);
		Processor4 pr4 = new Processor4(cdl, obj);
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.submit(pr1);
		executor.submit(pr2);
		executor.submit(pr3);
		executor.submit(pr4);

		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(obj.toString());
	}

}
