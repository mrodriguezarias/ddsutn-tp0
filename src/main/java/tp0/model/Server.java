package tp0.model;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import tp0.Settings;

public class Server {
	private static Server instance = new Server();
	
	private final static String location = "http://notitas.herokuapp.com";
	
	private String token;
	
	private WebTarget target;
	
	private Server() {
		Client client = ClientBuilder.newClient();
		target = client.target(location);		
	}
	
	public static Server getInstance() {
		return instance;
	}
	
	private String getToken() {
		if(token == null) {
			token = Settings.get("token");
		}
		
		return token;
	}
	
	private <T> Invocation buildRequest(String path, T putResource) {
		Invocation.Builder request = target.path(path)
		.request(MediaType.APPLICATION_JSON_TYPE)
		.header("Authorization", "Bearer " + getToken());
		
		if(putResource != null) {
			Entity<T> entity = Entity.entity(putResource, MediaType.APPLICATION_JSON_TYPE);
			return request.buildPut(entity);
		}
		
		return request.buildGet();
	}
	
	private Invocation buildRequest(String path) {
		return buildRequest(path, null);
	}
	
	public String getResource(String path) {
		return buildRequest(path).invoke(String.class);
	}
	
	public Student getStudent() {
		return buildRequest("student").invoke(Student.class);
	}
	
	public Assignments getAssignments() {
		return buildRequest("student/assignments").invoke(Assignments.class);
	}
	
	public boolean setStudent(Student student) {
		return buildRequest("student", student).invoke().getStatus() == 201;
	}
	
	public boolean tokenIsValid(String token) {
		this.token = token;
		boolean valid = buildRequest("student").invoke().getStatus() != 401;
		this.token = null;
		
		return valid;
	}
}
