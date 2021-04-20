import java.util.ArrayList;

public class Day {
	private int selectDay;
	ArrayList<TimeSlot> timeslotList = new ArrayList<TimeSlot>();
	
	public Day(int s) {
		selectDay = s;
		
		TimeSlot eight = new TimeSlot(1);
		TimeSlot ten = new TimeSlot(2);
		TimeSlot twelve = new TimeSlot(3);
		TimeSlot two = new TimeSlot(4);
		TimeSlot four = new TimeSlot(5);

		timeslotList.add(eight);
		timeslotList.add(ten);
		timeslotList.add(twelve);
		timeslotList.add(two);
		timeslotList.add(four);
	}
	
	public int getDay() {
		return selectDay;
	}
	
	public ArrayList<TimeSlot> getTimeSlotList() {
		return timeslotList;
	}

}
