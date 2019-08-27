package classes;

/**
 * @author dylan
 *
 */
public class Process2 implements Runnable {

	private Pojo field1;
	
	public Process2(Pojo field1) {
		super();
		this.field1 = field1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		synchronized(field1) {
			field1.append2(field1,"there!");
		}
	}
	
	
	
}
