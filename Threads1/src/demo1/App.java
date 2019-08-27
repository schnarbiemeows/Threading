package demo1;

/**
 * @author dylan
 *
 */
class Runner extends Thread {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
		Runner runner1 = new Runner();
		runner1.start();

		Runner runner2 = new Runner();
		runner2.start();
	}

}
