package com.stefanini.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.stefanini.model.Pessoa;

@Named
@RequestScoped
public class PessoaDao extends GenericDAO<Pessoa>{

	public PessoaDao() {
		super(Pessoa.class);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -30860686489829483L;
	
}
