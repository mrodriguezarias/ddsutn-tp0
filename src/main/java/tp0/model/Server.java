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
	
	private WebTarget target;
	
	private Server() {
		Client client = ClientBuilder.newClient();
		target = client.target(location);		
	}
	
	public static Server getInstance() {
		return instance;
	}
	
	private <T> Invocation buildRequest(String path, T putResource, String token) {
		Invocation.Builder request = target.path(path)
		.request(MediaType.APPLICATION_JSON_TYPE)
		.header("Authorization", "Bearer " + token);
		
		if(putResource != null) {
			Entity<T> entity = Entity.entity(putResource, MediaType.APPLICATION_JSON_TYPE);
			return request.buildPut(entity);
		}
		
		return request.buildGet();
	}
	
	private <T> Invocation buildRequest(String path, T putResource) {
		return buildRequest(path, putResource, Settings.get("token"));
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
		return buildRequest("student", null, token).invoke().getStatus() != 401;
	}
}
