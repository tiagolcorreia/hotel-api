package br.com.cvc.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.cvc.hotel.controller.model.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

	@ExceptionHandler({ BindException.class })
	public ResponseEntity<ExceptionResponse> handleBindException(BindException ex) {
		log.error("ExceptionHandlerController: ", ex);
		return ResponseEntity.badRequest().body(new ExceptionResponse(HttpStatus.BAD_REQUEST.toString(), ex.getMessage()));
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ExceptionResponse> handleGlobal(Exception ex) {
		log.error("ExceptionHandlerController: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponse(ex));
	}
}
