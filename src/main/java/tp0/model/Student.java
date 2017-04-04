package tp0.model;

public class Student {
	public String code;
	public String first_name;
	public String last_name;
	public String github_user;
	
	public Student() {}
	
	public Student(String first_name, String last_name, String github_user) {
		this.first_name = first_name;
		this.last_name= last_name;
		this.github_user= github_user;
	}
	
	public String toString() {
		return String.format("%d - %s, %s (%s)", code, last_name, first_name, github_user);
	}
}
