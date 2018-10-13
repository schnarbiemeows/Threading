import java.util.concurrent.Semaphore;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// tutorial 12: semaphores
		
		// each semaphore has a number of permits
		Semaphore sem = new Semaphore(1);
		// this will increase the # of available permits
		sem.release();
		// this will decrease the # of available permits
		sem.acquire(); // acquire will wait if there are no permits available
		// so a semaphore with 1 permit is basically a lock, except that you can 
		// release(unlock) from a different thread than the one that you acquired in(locked)
		// versus a lock, where you have to unlock from the same thread that you locked in
		// semaphores are usually used to control access to some resource
		System.out.println("Available permits: " + sem.availablePermits());
	}
}
