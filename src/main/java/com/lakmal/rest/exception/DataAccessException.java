package com.lakmal.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataAccessException extends Exception {

	/**
	 * DataAccessException
	 */
	private static final long serialVersionUID = 5669525583413934113L;

	public DataAccessException() {
	}

	// Constructor that accepts a message
	public DataAccessException(String message) {
		super(message);
	}
}
