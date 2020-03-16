package br.com.cvc.hotel.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private String message;
	private String[] details;

	public ExceptionResponse(Exception e) {
		this.message = e.getMessage();
	}

	public ExceptionResponse(Throwable e, String[] details) {
		this.message = e.getMessage();
		this.details = details;
	}

	public ExceptionResponse(String message, String details) {
		this(message, new String[] { details });
	}
}
