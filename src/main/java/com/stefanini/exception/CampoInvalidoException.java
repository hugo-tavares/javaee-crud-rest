package com.stefanini.exception;

public class CampoInvalidoException extends Exception{
	
	private static final long serialVersionUID = -8980188128514343255L;

	
	public CampoInvalidoException() {
		super("Campo inválido como chave primária.");
	}
	
}
