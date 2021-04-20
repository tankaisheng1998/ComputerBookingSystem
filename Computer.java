
public class Computer {
	private int computerId;
	private String status;
	private Boolean isBook;
	
	public Computer(int m, String s, boolean b) {
		computerId = m;
		status = s;
		isBook= b;
	}
	
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}

	public int getComputerId() {
		return computerId;
	}

	public void setStatus(String eStatus) {
		status = eStatus;
	}

	public String getStatus() {
		return status;
	}
	
	public boolean getBook() {
		return isBook;
	}
	
	public void book() {
		isBook = true;
	}

	public void unbook() {
		isBook = false;
	}
}
