package com.stefanini.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.stefanini.model.Pessoa;

@Named("PessoaDAO")
@RequestScoped
public class PessoaDao extends GenericDao<Pessoa>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 153535387424452772L;
	
	public PessoaDao() {
		super(Pessoa.class);
	}

	/**
	 * 
	 */
	//private static final long serialVersionUID = -30860686489829483L;
	
}
