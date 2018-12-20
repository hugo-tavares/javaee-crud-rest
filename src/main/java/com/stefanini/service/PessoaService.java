package com.stefanini.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.dao.PessoaDao;
import com.stefanini.exception.PessoaInexistenteException;
import com.stefanini.model.Pessoa;

@Named
@ApplicationScoped
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1328714322378603907L;
	@Inject
	PessoaDao pessoaDao;

	public Pessoa find(Integer id) throws PessoaInexistenteException {
		Pessoa pessoaFound = pessoaDao.find(id);
		if (pessoaFound != null)
			return pessoaFound;
		throw new PessoaInexistenteException();
	}

	public Pessoa insert(Pessoa pessoa) {
		pessoa.setId(null);
		return pessoaDao.insert(pessoa);
	}

	public List<Pessoa> showAll() {
		return pessoaDao.findAll();
	}

	public void update(Pessoa nova) throws PessoaInexistenteException {
		Pessoa antiga = pessoaDao.find(nova.getId());
		if (antiga != null) {
			antiga.setCpf(nova.getCpf());
			antiga.setIdade(nova.getIdade());
			antiga.setNome(nova.getNome());
			pessoaDao.insert(antiga);
		} else
			throw new PessoaInexistenteException();

	}

	public void delete(int id) throws PessoaInexistenteException {
		Pessoa pessoa = pessoaDao.find(id);
		if (pessoa != null) {
			pessoaDao.delete(pessoa);
		} else
			throw new PessoaInexistenteException();

	}
}
