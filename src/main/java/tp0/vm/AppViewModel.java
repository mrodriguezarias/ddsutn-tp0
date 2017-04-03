package tp0.vm;

import org.uqbar.commons.utils.Observable;

import tp0.Settings;
import tp0.model.Server;
import tp0.model.Student;

@Observable
public class AppViewModel {
	
	private Student student;
	
	public AppViewModel() {
		Server server = Server.getInstance();
		
		student = new Student("Nikola", "Tesla", "ntesla56");
		
//		System.out.println(server.setStudent(student));
		System.out.println(server.getStudent());
//		System.out.println(server.getAssignments());
	}
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student studentReceived){
		this.student = studentReceived;
	}

	public boolean tokenIsSet() {
		String token = Settings.get("token");
		return token != null && !token.isEmpty();
	}
	
	public void searchStudent() {
		
	}
	
}
