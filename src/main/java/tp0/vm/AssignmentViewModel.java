package tp0.vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import tp0.model.Assignment;
import tp0.model.Assignments;
import tp0.model.Server;

@Observable
public class AssignmentViewModel {
	
	private List<Assignment> assignments = new ArrayList<>();
	
	public AssignmentViewModel() {}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
	
	public void updateAssignments() {
		Assignments assignments = Server.getInstance().getAssignments();
		this.assignments = assignments.getAssignments();
	}
	
}
