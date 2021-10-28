package com.bancoexterior.nexo.montomincomision.exception;

public class BadRequestException extends RuntimeException {

   
	public BadRequestException(String codigo) {
    	super(codigo);
    }

    /**
    * 
    */
	private static final long serialVersionUID = 1L;

}
