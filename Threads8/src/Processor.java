import java.util.Scanner;

/**
 * @author dylan
 *
 */
public class Processor {

	/**
	 * @throws InterruptedException
	 */
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ....");
			// can only call wait within synchronized code blocks
			wait();
			System.out.println("Resumed ....");
		}
	}

	/**
	 * @throws InterruptedException
	 */
	public void consume() throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);

		synchronized (this) {
			// note: using same lock as above block
			System.out.println("Waiting for return key ....");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			// notify can only be called within a synchronized code block
			notify();
			// this line shows that control is relinquished not when notify() is called,
			// but when the synchronized block is exited!
			Thread.sleep(5000);
		}
	}
}
