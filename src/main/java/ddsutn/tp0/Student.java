package ddsutn.tp0;

public class Student {
	public int code;
	public String first_name;
	public String last_name;
	public String github_user;
	
	public String toString() {
		return String.format("%d - %s, %s (%s)", code, last_name, first_name, github_user);
	}
}
