import java.util.ArrayList;

public class Booking {
	Day day;
	Student student;

	int selectts;
	int selectcom;

	public Booking(Student s, Day d) {
		student = s;
		day = d;
	}

	public Day getDay() {
		return day;
	}

	// new
	public void settime(int time) {
		selectts = time;
	}

	public void setComp(int computerID) {
		selectcom = computerID;
	}

	public boolean bookComp(int selectts, int selectcom) {
		if (day.getTimeSlotList().get(selectts).getCompList().get(selectcom).getBook()) {
			return false;
		} else {
			day.getTimeSlotList().get(selectts).getCompList().get(selectcom).book();
			settime(selectts);
			setComp(selectcom);
			return true;
		}
	}
	
	public boolean unbookComp() {
		day.getTimeSlotList().get(selectts).getCompList().get(selectcom).unbook();
		return true;
	}
	
	public Student getStudent() {
		return student;
	}
}
