import java.util.ArrayList;

public class TimeSlot {
	private int selectTimeSlot;
	private ArrayList<Computer> comList = new ArrayList<Computer>();
	
	public TimeSlot(int ts) {
		selectTimeSlot = ts;
		
		for (int i=1; i<=40; i++) {
			Computer com = new Computer(i,"working", false);
			comList.add(com);
		}
	}

	public int getDay() {
		return selectTimeSlot;
	}
	
	public ArrayList<Computer> getCompList() {
		return comList;
	}
}
