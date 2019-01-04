package com.stefanini.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.stefanini.model.Candidato;

@Named("candidatoDao")
@RequestScoped
public class CandidatoDao extends GenericDao<Candidato>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 153535387424452772L;
	
	public CandidatoDao() {
		super(Candidato.class);
	}

	
}
