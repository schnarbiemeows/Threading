import java.util.concurrent.Callable;

public class Summer implements Callable<Integer> {

	private int sum = 0;
	int[] input;
	int start, end;
	
	public Summer(int[] input, int start, int end) {
		super();
		this.input = input;
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		for(int i=start;i<end;i++) {
			sum += input[i];
		}
		return sum;
	}
}
