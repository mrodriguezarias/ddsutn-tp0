package ddsutn.tp0;

import org.uqbar.commons.utils.Observable;

@Observable
public class AppViewModel {
	
	private Student student;
	
	public AppViewModel() {
		Server server = Server.getInstance();
		
		student = new Student();
		student.first_name = "Lady";
		student.last_name = "Sybil";
		student.github_user = "dabbey1923";
		
		System.out.println(server.setStudent(student));
		System.out.println(server.getStudent());
		System.out.println(server.getAssignments());	
		
	}
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student studentReceived){
		this.student = studentReceived;
	}
	
}
