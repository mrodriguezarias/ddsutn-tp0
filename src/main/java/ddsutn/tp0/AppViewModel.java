package ddsutn.tp0;

public class AppViewModel {
	public AppViewModel() {
		Server server = Server.getInstance();
		
		Student student = new Student();
		student.first_name = "Lady";
		student.last_name = "Sybil";
		student.github_user = "dabbey1923";
		
		System.out.println(server.setStudent(student));
		System.out.println(server.getStudent());
		System.out.println(server.getAssignments());
	}
}
