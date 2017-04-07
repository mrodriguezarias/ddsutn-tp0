package tp0.model;

import java.util.List;
import java.util.stream.Collectors;

public class Assignments {
	private List<Assignment> assignments;
	
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public String toString() {
		return assignments.stream().map(Object::toString).collect(Collectors.joining("\n"));
	}
}
