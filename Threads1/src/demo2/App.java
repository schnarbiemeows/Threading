package demo2;

/**
 * @author dylan
 *
 */
class Runner implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

/**
 * @author dylan
 *
 */
public class App {

	/**
	 * tutorial 1: starting threads
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		t1.start();
		t2.start();
	}

}
