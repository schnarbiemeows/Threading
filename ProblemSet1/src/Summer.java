import java.util.concurrent.Callable;

/**
 * @author dylan
 *
 */
public class Summer implements Callable<Integer> {

	private int sum = 0;
	int[] input;
	int start, end;

	/**
	 * @param input
	 * @param start
	 * @param end
	 */
	public Summer(int[] input, int start, int end) {
		super();
		this.input = input;
		this.start = start;
		this.end = end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		for (int i = start; i < end; i++) {
			sum += input[i];
		}
		return sum;
	}
}
