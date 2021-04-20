import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Faculty {
	Scanner sc = new Scanner(System.in);

	Screen screen = new Screen();
	Lab lab = new Lab("Lab FTSM");
	TimeSlot selectts = new TimeSlot(5);
	ArrayList<Day> dayList = new ArrayList<Day>();
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {
		Faculty index = new Faculty();
		index.runSystem();
	}

	public void runSystem() {
		String option = "default";
		Day Monday = new Day(1);
		Day Tuesday = new Day(2);
		Day Wednesday = new Day(3);
		Day Thursday = new Day(4);
		Day Friday = new Day(5);

		dayList.add(Monday);
		dayList.add(Tuesday);
		dayList.add(Wednesday);
		dayList.add(Thursday);
		dayList.add(Friday);

		while (!option.equals("3")) {
			option = screen.promptWelcomePage(sc, lab.getName());

			if (option.equals("1")) {
				String memberId = screen.promptStudentId(sc);
				String password = screen.promptPassword(sc);

				Student student = lab.getStudent(memberId, password);

				if (student == null)
					screen.displayIdOrPasswordNotFound();

				else {
					String menuOption = "default";

					while (!menuOption.equals("3")) {
						menuOption = screen.promptMenuOption(sc, student.getFirstName());

						if (menuOption.equals("1")) {
							Random rnd = new Random();
							int bookId = rnd.nextInt(999);
							String bookIdd = Integer.toString(bookId);
							Student std = new Student(bookIdd);
							students.add(std);

							System.out.println("\n1. Monday");
							System.out.println("2. Tuesday");
							System.out.println("3. Wednesday");
							System.out.println("4. Thursday");
							System.out.println("5. Friday");
							System.out.println("Please select the day of week");
							int selectday = sc.nextInt();
							if (selectday == 1 || selectday == 2 || selectday == 3 || selectday == 4
									|| selectday == 5) {
								System.out.println("\n1. 08:00am-10:00am");
								System.out.println("2. 10:00am-12:00pm");
								System.out.println("3. 12:00pm-14:00pm");
								System.out.println("4. 14:00pm-16:00pm");
								System.out.println("5. 16:00pm-18:00pm");
								System.out.println("Please select the timeslot");
								int selecttimeslot = sc.nextInt();
								if (selecttimeslot == 1 || selecttimeslot == 2 || selecttimeslot == 3
										|| selecttimeslot == 4 || selecttimeslot == 5) {
									screen.displayAllComputerNoStatus(selectts.getCompList());
									System.out.println("Please enter the computer ID");
									int selectcom = sc.nextInt();
									String status = "working";
									Iterator<Computer> it = selectts.getCompList().iterator();
									while (it.hasNext()) {
										Computer com = it.next();
										if (com.getComputerId() == selectcom) {
											if (com.getStatus().equals(status)) {
												Booking booking = new Booking(std, dayList.get(selectday - 1));
												if (booking.bookComp(selecttimeslot - 1, selectcom - 1)) {
													bookings.add(booking);
													System.out.println("Booking is successful"
															+ " and the Booking ID is " + std.getStudentId());
													break;
												} else {
													System.out.println("Sorry, computer is not available");
													break;
												}
											} else {
												System.out.println("Sorry, computer is under maintenance");
												break;
											}
										} else if (com.getComputerId() != selectcom && it.hasNext()) {
											continue;

										} else
											System.out.println("Sorry, invalid computer ID");
									}
								} else
									screen.displayInvalidOption();
							} else
								screen.displayInvalidOption();
						}

						else if (menuOption.equals("2")) {
							System.out.println("Enter your Booking ID");
							String studentid = sc.next();
							Iterator<Student> it = students.iterator();
							while (!it.hasNext()) {
								System.out.println("Sorry, invalid Booking ID");
								break;
							}
							while (it.hasNext()) {
								Student std = it.next();
								if (std.getStudentId().equals(studentid)) {
									for (Booking book : bookings) {
										if (book.getStudent().getStudentId() == std.getStudentId()) {
											if (book.unbookComp()) {

											}
										}
									}
									System.out.println("Cancel Booking is successful");
									students.remove(std);
									break;
								} else if (!std.getStudentId().equals(studentid) && it.hasNext()) {
									continue;
								} else {
									System.out.println("Sorry, invalid Booking ID");
								}
								break;
							}

						}

						else if (menuOption.equals("3")) {
							screen.displayGoodByePage(student.getFirstName());
							student = null; // set member to null to simulate logout
						}

						else
							screen.displayInvalidOption();

					} // closing while (!menuOption.equals("3"))

				}
			}

			else if (option.equals("2")) {
				String adminId = screen.promptAdminId(sc);
				String password = screen.promptPassword(sc);

				Admin admin = lab.getAdmin(adminId, password);

				if (admin == null)
					screen.displayIdOrPasswordNotFound();

				else {
					String menuOption = "default";

					while (!menuOption.equals("2")) {
						menuOption = screen.promptMenuOptionAdmin(sc, admin.getFirstName());

						if (menuOption.equals("1")) {
							screen.displayAllComputer(selectts.getCompList());
							screen.ChangeStatus(selectts.getCompList());
						} else if (menuOption.equals("2")) {
							screen.displayGoodByePage(admin.getFirstName());
							admin = null; // set member to null to simulate logout
						}

						else
							screen.displayInvalidOption();

					} // closing while (!menuOption.equals("2"))

				}
			}

			else if (option.equals("3"))
				screen.displayGoodByePage();

			else
				screen.displayInvalidOption();

		}
	}
}
