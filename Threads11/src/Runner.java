import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dylan
 *
 */
public class Runner {

	private Account acct1 = new Account();
	private Account acct2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	/**
	 * @param firstLock
	 * @param secondLock
	 */
	private void acquireLocks(Lock firstLock, Lock secondLock) {
		while (true) {
			// Acquire locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				if (gotFirstLock) {
					firstLock.unlock();
				}
				if (gotSecondLock) {
					secondLock.unlock();
				}
			}
			// locks not acquired
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * @throws InterruptedException
	 */
	public void firstThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			/*
			 * both threads will hit these two sets of locking statements at the same time
			 * one will hit it first and will be able to lock both locks, the other will
			 * have to wait lock1.lock(); lock2.lock(); a better solution is this method:
			 */
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(acct1, acct2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	/**
	 * @throws InterruptedException
	 */
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			// this is the right way order in which to lock these two locks
			// lock1.lock();
			// lock2.lock();
			// this however, will cause deadlock
			// because one thread will lock lock1, the other will lock lock2, and then
			// they will both be waiting to lock the other lock, which the other thread has
			/*
			 * lock2.lock(); lock1.lock();
			 */
			// a better solution is this method:
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(acct2, acct1, random.nextInt(100));
			} finally {
				// TODO: handle finally clause
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	/**
	 * 
	 */
	public void finished() {
		System.out.println("Account 1 balance: " + acct1.getBalance());
		System.out.println("Account 2 balance: " + acct2.getBalance());
		System.out.println("Total balance: " + (acct1.getBalance() + acct2.getBalance()));
	}
}
