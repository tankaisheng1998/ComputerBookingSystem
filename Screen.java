import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Screen {
	public String promptWelcomePage(Scanner sc, String labName) {
		System.out.println("\n---------------------------");
		System.out.println("Welcome to " + labName);

		System.out.println("\n1. Login");
		System.out.println("2. AdminLogin");
		System.out.println("3. Exit");

		System.out.println("\nEnter your option: ");
		String option = sc.next();
		return option;
	}

	public String promptStudentId(Scanner sc) {
		System.out.println("\nEnter your student id: ");
		String studentId = sc.next();
		return studentId;
	}

	public String promptAdminId(Scanner sc) {
		System.out.println("\nEnter your admin id: ");
		String adminId = sc.next();
		return adminId;
	}

	public String promptPassword(Scanner sc) {
		System.out.println("Enter password: ");
		String password = sc.next();
		return password;
	}

	public void displayIdOrPasswordNotFound() {
		System.out.println("\nError: Invalid member id or password");
	}

	public String promptMenuOption(Scanner sc, String name) {
		System.out.println("\nHello, " + name);
		System.out.println("\n1. Book computer");
		System.out.println("2. Cancel Booking");
		System.out.println("3. Logout");

		System.out.println("\nEnter your option: ");
		String menuOption = sc.next();
		return menuOption;
	}

	public String promptMenuOptionAdmin(Scanner sc, String name) {
		System.out.println("\nHello, " + name);
		System.out.println("\n1. Set Computer's Status");
		System.out.println("2. Logout");

		System.out.println("\nEnter your option: ");
		String menuOption = sc.next();
		return menuOption;
	}

	public void displayInvalidOption() {
		System.out.println("\nError: Invalid option");
	}

	public void displayGoodByePage(String name) {
		System.out.println("\nThank you. Have a good day " + name);
	}

	public void displayGoodByePage() {
		System.out.println("\nThank you. Have a good day");
	}

	public void displayAllComputerNoStatus(ArrayList<Computer> c) {
		for (int i = 0; i < c.size(); i++) {
			System.out.println((i + 1) + ". Computer ID = " + c.get(i).getComputerId());
		}
	}

	public void displayAllComputer(ArrayList<Computer> c) {
		for (int i = 0; i < c.size(); i++) {
			System.out.println(
					(i + 1) + ". Computer ID = " + c.get(i).getComputerId() + " and it is " + c.get(i).getStatus());
		}
	}

	public void ChangeStatus(ArrayList<Computer> c) {
		System.out.println("Enter the computer ID: ");
		Iterator<Computer> it = c.iterator();
		Scanner input = new Scanner(System.in);
		int computerId = input.nextInt();
		String comStatus;
		String s1 = "working";
		String s2 = "undermaintenance";
		while (it.hasNext()) {
			Computer com = it.next();
			if (com.getComputerId() == computerId) {
				System.out.println("Enter the computer'status: ");
				System.out.println("(note: only enter working or undermaintenance only)");
				comStatus = input.next();
				if (comStatus.equals(s1) || comStatus.equals(s2)) {
					com.setStatus(comStatus);
					System.out.println("Computer’s status is set successfully");
					break;
				} else {
					System.out.println("Sorry, invalid status");
					break;
				}
			} else if (com.getComputerId() != computerId && it.hasNext()) {
				continue;

			} else {
				System.out.println("Sorry, invalid computer ID");

			}

		}
	}
}
