package tp0.vm;

import org.uqbar.commons.utils.Observable;

import tp0.Settings;
import tp0.model.Server;

@Observable
public class TokenViewModel {
	
	private String token;
	private String message;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String error) {
		this.message = error;
	}
	
	public boolean saveToken() {
		boolean validToken = false;
		setMessage("Verificando…");
		
		validToken = Server.getInstance().tokenIsValid(token);
		
		if(validToken) {
			Settings.set("token", token);
		} else {
			setMessage("Error: token inválido.");
		}
		
		return validToken;
	}
	
}
