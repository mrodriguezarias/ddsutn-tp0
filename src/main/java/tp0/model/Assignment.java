package tp0.model;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class Assignment {
	private int id;
	private String title;
	private String description;
	private List<Grade> grades;
	private String gradesString;
	private String average;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
		if(!grades.isEmpty()) {
			double average = grades.stream().mapToInt(Grade::intValue).average().getAsDouble();
			this.average = String.format("%.2f", average);
		} else {
			this.average = "";
		}
	}
	
	public String getGradesString() {
		gradesString = grades.stream().map(Object::toString).collect(Collectors.joining("; "));
		return gradesString;
	}

	public void setGradesString(String gradesString) {
		this.gradesString = gradesString;
	}
	
	public String getAverage() {
		return average;
	}
	
	public void setAverage(String average) {
		this.average = average;
	}
	
	public String getStatus() {
		status = isPassed() ? "Aprobado" : "Reprobado";
		if(grades.isEmpty()) status = "";
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isPassed() {
		if(average.isEmpty()) return false;
		return Double.parseDouble(average) >= 6;
	}
	
	public String toString() {
		String extendedTitle = title + (description != null ? (": " + description) : "");
		String gradesString = grades.stream().map(Object::toString).collect(Collectors.joining(", "));
		return String.format("%d - %s - %s", id, extendedTitle, gradesString);
	}
}