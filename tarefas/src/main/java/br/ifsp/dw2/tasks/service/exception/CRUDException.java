package br.ifsp.dw2.tasks.service.exception;

public class CRUDException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CRUDException(String message) {
		super(message);
	}

}
