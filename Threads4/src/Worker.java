import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author dylan
 *
 */
public class Worker {

	// this app is designed to show that each Class has 1 mutex lock, so for the 2
	// synchronized methods below, they are both referring to the same lock
	private Random random = new Random();

	// these two objects are used just for their locks
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	// so we can comment out the 'synchronized' in each method call and surround
	// each method body with a synchronized block that refers to the objects above!
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	/**
	 * 
	 */
	public /* synchronized */ void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}

	/**
	 * 
	 */
	public /* synchronized */ void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	/**
	 * 
	 */
	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	/**
	 * 
	 */
	public void main() {
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		// process();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken: " + (end - start));
		System.out.println("List 1 size = " + list1.size() + " List 2 size = " + list2.size());
	}
}
