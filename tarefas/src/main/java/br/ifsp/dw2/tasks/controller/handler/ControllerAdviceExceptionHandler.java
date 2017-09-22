package br.ifsp.dw2.tasks.controller.handler;

import br.ifsp.dw2.tasks.service.exception.CRUDException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(CRUDException.class)
	public ResponseEntity<String> handleCRUDException(CRUDException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
