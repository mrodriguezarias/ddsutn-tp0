package tp0.model;

import java.util.List;
import java.util.stream.Collectors;

public class Assignments {
	public List<Assignment> assignments;
	
	public String toString() {
		return assignments.stream().map(Object::toString).collect(Collectors.joining("\n"));
	}
}
