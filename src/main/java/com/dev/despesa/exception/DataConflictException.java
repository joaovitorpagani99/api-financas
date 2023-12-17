package com.dev.despesa.exception;

public class DataConflictException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataConflictException(String mensagem) {
		super(mensagem);
	}

}
