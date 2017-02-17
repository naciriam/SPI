package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthentificationException extends RuntimeException  {
	private String message;

	public AuthentificationException() {
		// TODO Auto-generated constructor stub
	}

	public AuthentificationException(String message) {
		super(message);
		this.message = message;
	}

	
}
