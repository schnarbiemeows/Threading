import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dylan
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long begin = System.currentTimeMillis();
		int[] nums = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170 };
		int blocksize = 3, finalNum = 0;
		int numBlocks = nums.length / blocksize;
		if (nums.length % blocksize > 0)
			numBlocks++;
		List<Future<Integer>> subtotals = new ArrayList<Future<Integer>>();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		int start = 0, end = 0;
		for (int i = 0; i < numBlocks; i++) {
			start = i * blocksize;
			end = start + blocksize;
			if (end > nums.length)
				end = nums.length;
			Future<Integer> subtotal = executor.submit(new Summer(nums, start, end));
			subtotals.add(subtotal);
		}
		for (Future<Integer> item : subtotals) {
			finalNum += item.get();
		}
		long finish = System.currentTimeMillis();
		System.out.println("total = " + finalNum + " : time = " + (finish - begin));
	}

}
