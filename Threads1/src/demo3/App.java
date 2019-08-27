package demo3;

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
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
	}

}
