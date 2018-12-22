package classes;

/**
 * @author dylan
 *
 */
public class Process1 implements Runnable {

	private Pojo field1;
	
	public Process1(Pojo field1) {
		super();
		this.field1 = field1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized(field1) {
			field1.append1(field1,"Hi ");
		}
	}
	
	

}
