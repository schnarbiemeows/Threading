
/**
 * @author dylan
 *
 */
public class App {

	private int count = 0;

	/**
	 * tutorial 3: the synchronized keyword
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}

	/**
	 * the synchronized keyword acts as a mutex lock for the method, it also makes
	 * the count variable volatile(current state is accessible to all threads)
	 */
	public synchronized void increment() {
		count++; // synchronized is needed because this line here is NOT an atomic transaction!
	}

	/**
	 * 
	 */
	private void doWork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is: " + count);
	}

}
