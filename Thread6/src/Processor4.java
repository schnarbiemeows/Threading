import java.util.concurrent.CountDownLatch;

/**
 * @author dylan
 *
 */
public class Processor4 implements Runnable {

	private CountDownLatch latch;
	private CommonObj commonObj;

	public CommonObj getCommonObj() {
		return commonObj;
	}

	public void setCommonObj(CommonObj commonObj) {
		this.commonObj = commonObj;
	}

	/**
	 * @param latch
	 * @param commonObj
	 */
	public Processor4(CountDownLatch latch, CommonObj commonObj) {
		super();
		this.latch = latch;
		this.commonObj = commonObj;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		commonObj.setName4("d");
		latch.countDown();
	}

}
