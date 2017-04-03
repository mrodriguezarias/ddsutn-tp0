package tp0.model;

import java.util.List;
import java.util.stream.Collectors;

public class Assignment {
	public int id;
	public String title;
	public String description;
	public List<Grade> grades;
	
	public String toString() {
		String extendedTitle = title + (description != null ? (": " + description) : "");
		String gradesString = grades.stream().map(Object::toString).collect(Collectors.joining(", "));
		return String.format("%d - %s - %s", id, extendedTitle, gradesString);
	}
}