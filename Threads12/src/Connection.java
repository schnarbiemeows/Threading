import java.util.concurrent.Semaphore;

public class Connection {

		private static Connection instance = new Connection();
		private Semaphore sem = new Semaphore(10, true);
		// the true variable above is called the fairness parameter, which guarantees the the first
		// threads to call acquire will acquire the permit, regardless of the thread priority level
		private int connections = 0;
		private Connection() {
		
		}
		
		public static Connection getInstance() {
			return instance;
		}
		
		public void doConnect() {
			synchronized(this) {
				connections++;
				System.out.println("Current connections: " + connections);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this) {
				connections--;
				System.out.println("Current connections: " + connections);
			}
			
		}
		public void connect() {
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				doConnect() ;
			}
			finally {
				// remember, we always have to guarantee unlocks/releases
				sem.release();
			}
		}
}
