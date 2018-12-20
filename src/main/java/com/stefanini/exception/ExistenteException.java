package com.stefanini.exception;

public class ExistenteException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ExistenteException(String generica) {
		super (generica);
	}
}
