
public class TicketBookingTask implements Runnable{

	private TicketReservationSystem reservationSystem;
	private String trainName;
	private int ticketCount;
	
	public TicketBookingTask(TicketReservationSystem reservationSystem, String trainName, int ticketCount) {
		super();
		this.reservationSystem = reservationSystem;
		this.trainName = trainName;
		this.ticketCount = ticketCount;
	}

	@Override
	public void run() {
		synchronized(reservationSystem) {
		reservationSystem.reserveTicket(trainName, ticketCount);
		}
	}

	
}
