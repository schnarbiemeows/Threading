import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dylan
 *
 */
public class App2 {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<List<Things>> task = new Callable<List<Things>>() {
			@Override
			public List<Things> call() throws Exception {
				List<Things> list = new ArrayList<Things>();
				Things item1 = new Things("a", 1);
				list.add(item1);
				Things item2 = new Things("b", 2);
				list.add(item2);
				return list;
			}
		};
		Future<List<Things>> future = executorService.submit(task);

		// the list from above, returns once execution is complete
		List<Things> list = future.get();
		list.forEach(item -> System.out.println(item.getName()));
	}

}
