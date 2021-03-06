import java.util.LinkedList;
import java.util.Random;

/**
 * @author dylan
 *
 */
public class Processor {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	/**
	 * @throws InterruptedException
	 */
	public void produce() throws InterruptedException {
		// gonna add items to the list
		int value = 0;

		while (true) {
			synchronized (lock) {

				while (list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	/**
	 * @throws InterruptedException
	 */
	public void consume() throws InterruptedException {
		// gonna remove items for the List
		Random random = new Random();
		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println(" ; value is: " + value);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}

	}
}
