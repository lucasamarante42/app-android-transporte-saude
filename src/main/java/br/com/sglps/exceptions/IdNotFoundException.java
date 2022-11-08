package br.com.sglps.exceptions;

import java.io.Serializable;

public class IdNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public IdNotFoundException() {
		this("Id não disponível");
	}

	public IdNotFoundException(String message) {
		this.message = System.currentTimeMillis() + " : " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
