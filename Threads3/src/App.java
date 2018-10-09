
public class App {

	private int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.doWork();
	}

	
	private void doWork() {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				
				for(int i=0; i<10000; i++) {
					count++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				
				for(int i=0; i<10000; i++) {
					count++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
	}

}
