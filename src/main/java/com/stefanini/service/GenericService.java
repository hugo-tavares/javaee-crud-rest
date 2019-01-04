package com.stefanini.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import com.stefanini.dao.GenericDao;
import com.stefanini.exception.CampoInvalidoException;
import com.stefanini.exception.PessoaInexistenteException;

@Named
@Dependent
public class GenericService<T, Dao> implements Serializable {

	private static final long serialVersionUID = 1328714322378603907L;

	
	GenericDao<T> genericDao;
	
	public T find(Integer id) throws PessoaInexistenteException {
		T tFound = genericDao.find(id);
		if (tFound != null)
			return tFound;
		throw new PessoaInexistenteException();
	}

	public T insert(T t) throws CampoInvalidoException{

		return genericDao.insert(t);
	}

	public List<T> showAll() {
		return genericDao.findAll();
	}

	public void update(T nova) throws PessoaInexistenteException {
		genericDao.update(nova);
	}

	public void delete(int id) throws PessoaInexistenteException {
		T t = genericDao.find(id);
		if (t != null) {
			genericDao.delete(t);
		} else
			throw new PessoaInexistenteException();

	}
}
