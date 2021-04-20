import java.util.ArrayList;

public class Lab {
	private String name;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Admin> adminList = new ArrayList<Admin>();

	public Lab(String n) {
		name = n;
		
		// Hard code library members for demo purposes
		Student member1 = new Student("Jonathan", "Lee", "m001", "j123");
		Student member2 = new Student("Ryan", "Chong", "m002", "c123");
		
		studentList.add(member1);
		studentList.add(member2);
		
		Admin admin1 = new Admin("Lelouch", "Lamperouge", "l001", "le123");

		adminList.add(admin1);

	}
	
	public String getName() {
		return name;
	}
	
	public Student getStudent(String id, String pwd) {
		for (Student student : studentList) {
			if (student.getStudentId().equals(id) && student.getPassword().equals(pwd))
				return student;
		}
		
		// if member with the same id and password not found in the library's member list, 
		// return null object
		return null;
	}
	
	public Admin getAdmin(String id, String pwd) {
		for (Admin admin : adminList) {
			if (admin.getAdminId().equals(id) && admin.getPassword().equals(pwd))
				return admin;
		}
		return null;
	}

}
