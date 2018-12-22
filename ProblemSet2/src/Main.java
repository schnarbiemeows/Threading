import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	/*
	 * A Map contains Train number and no of seats available. Demonstrate
	 * concurrency problem during reserveTickets(n) operation and provide solution.
	 */
	/*
	 * Map<String, Integer> trainInfo = new HashMap<String,Integer>();
	 * trainInfo.put("a",100); trainInfo.put("b",100); .... class
	 * TicketReservationSystem { public void reserveTicket(String trainName, int
	 * ticketCount) { // show problem and define a solution }
	 */
	public static void main(String[] args) {

		TicketReservationSystem reservationSystem = new TicketReservationSystem();
		String trainName = "a";
		int ticketCount = 50;

		Thread t1 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));
		Thread t2 = new Thread(new TicketBookingTask(reservationSystem, trainName, ticketCount));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Available tickets for train - " + trainName + " are "
				+ reservationSystem.getAvailableTickets(trainName));
	}

}
