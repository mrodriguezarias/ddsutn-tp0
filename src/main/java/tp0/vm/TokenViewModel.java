package tp0.vm;

import org.uqbar.commons.utils.Observable;

import tp0.Settings;
import tp0.model.Server;

@Observable
public class TokenViewModel {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean saveToken() {
		boolean validToken = Server.getInstance().tokenIsValid(token);
		
		if(validToken) {
			Settings.set("token", token);
		}
		
		return validToken;
	}
}
