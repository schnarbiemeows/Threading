import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner2 {

	private int count = 0;
	// this is a lock that can be locked multiple times, and has to be unlocked the same
	// number of times to be truly unlocked
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private void increment() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}
	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ....");
		Thread.sleep(10000);
		cond.await();	// this statement in essence unlocks the lock 
		System.out.println("Woken up!");
		// gotta wrap the unlock inside a finally in case the increment() method
		// throws an exception, it'll never get unlocked
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		System.out.println("Locking ....");
		lock.lock(); 	// this lock happens after the cond.await(), which won't hppen until
		// Thread.sleep(10000); finishes
		System.out.println("Press the return key!");;
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		cond.signal();
		try {
			increment();
		} finally {
			Thread.sleep(10000);
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Count is: " + count);
	}
}
