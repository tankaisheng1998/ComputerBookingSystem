
public class Student {
	private String firstName;
	private String lastName;
	private String studentId;
	private String password;
	
	public Student(String f, String l, String m, String p) {
		firstName = f;
		lastName = l;
		studentId = m;
		password = p;
	}
	
	public Student(String id) {
		studentId = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getPassword() {
		return password;
	}
}
