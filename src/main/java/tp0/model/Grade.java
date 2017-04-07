package tp0.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Grade {
	private int id;
	private String value;
	private String created_at;
	private String updated_at;
	
	private static HashMap<String, Integer> valuesMap = new HashMap<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	private static HashMap<String, Integer> getValuesMap() {
		if(valuesMap.isEmpty()) {
			valuesMap.put("M", 3);
			valuesMap.put("R", 5);
			valuesMap.put("B", 7);
			valuesMap.put("MB", 9);
		}
		
		return valuesMap;
	}
	
	public String toString() {
		return value;
	}
	
	public int intValue() {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException e) {
			List<String> signs = new ArrayList<>(Arrays.asList(value.split("(?=[-+])")));
			int base = getValuesMap().get(signs.remove(0));
			int extra = signs.stream().mapToInt(s -> s.equals("+") ? 1 : -1).sum();
			return base + extra;
		}
	}
}
