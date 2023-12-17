package com.dev.despesa.exception;

public class InternalServerErrorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(String mensagem) {
		super(mensagem);
	}

	
}
