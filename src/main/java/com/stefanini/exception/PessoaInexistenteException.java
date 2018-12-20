package com.stefanini.exception;

public class PessoaInexistenteException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PessoaInexistenteException() {
		super ("Pessoa não cadastrada");
	}
}
