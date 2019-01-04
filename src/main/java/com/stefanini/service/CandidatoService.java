package com.stefanini.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.dao.CandidatoDao;
import com.stefanini.exception.PessoaInexistenteException;
import com.stefanini.model.Candidato;

@Named
@ApplicationScoped
public class CandidatoService implements Serializable {

	private static final long serialVersionUID = 1328714322378603907L;
	@Inject
	CandidatoDao candidatoDao;

	public Candidato find(Integer id) throws PessoaInexistenteException {
		Candidato candidatoFound = candidatoDao.find(id);
		if (candidatoFound != null)
			return candidatoFound;
		throw new PessoaInexistenteException();
	}

	public Candidato insert(Candidato candidato) {
		return candidatoDao.insert(candidato);
	}

	public List<Candidato> showAll() {
		return candidatoDao.findAll();
	}

	public Candidato update(Candidato novo) throws PessoaInexistenteException {
		Candidato antigo = candidatoDao.find(novo.getNumero());
		if (antigo != null) {
			candidatoDao.update(novo);
			return novo;
		} else
			throw new PessoaInexistenteException();

	}

	public void delete(int numero) throws PessoaInexistenteException {
		Candidato candidato= candidatoDao.find(numero);
		if (candidato!= null) {
			candidatoDao.delete(candidato);
		} else
			throw new PessoaInexistenteException();

	}
}
