import java.util.HashMap;
import java.util.Map;

public class TicketReservationSystem {

	Map<String, Integer> trainInfo = new HashMap<String,Integer>();
	
	public Map<String, Integer> getTrainInfo() {
		return trainInfo;
	}

	public void setTrainInfo(Map<String, Integer> trainInfo) {
		this.trainInfo = trainInfo;
	}

	public TicketReservationSystem() {
		super();
		trainInfo.put("a",100); 
		trainInfo.put("b",100);
	}

	public void reserveTicket(String trainName, int ticketCount) {
		int ticketsLeft = trainInfo.get(trainName).intValue();
		if(ticketsLeft<ticketCount) {
			System.out.println("not enough tickets!");
		} else {
			System.out.println("buying " + ticketCount + " tickets");
			ticketsLeft -= ticketCount;
			trainInfo.put(trainName, ticketsLeft);
		}
	}

	public int getAvailableTickets(String trainName) {
		return trainInfo.get(trainName).intValue();
	}
}
