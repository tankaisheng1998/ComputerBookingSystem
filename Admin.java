
public class Admin {
	private String firstName;
	private String lastName;
	private String adminId;
	private String password;
	
	public Admin(String f, String l, String m, String p) {
		firstName = f;
		lastName = l;
		adminId = m;
		password = p;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAdminId() {
		return adminId;
	}
	
	public String getPassword() {
		return password;
	}
}
