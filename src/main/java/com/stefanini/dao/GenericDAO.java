package com.stefanini.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.stefanini.interceptor.InterceptorTransactional;

@Named
@Dependent
public class GenericDao<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1289446525582740316L;

	@Inject
	private EntityManager entityManager;
	
	private Class<T> type;
	
	public GenericDao(Class<T> type) {
		this.type = type;
	}
	
	public T find(Integer id) {
		return (T) entityManager.find(type,id);
	}
	
	public List<T> findAll() {
		//usando criteria pra ter tipagem forte
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(type); // define o tipo de retorno como sendo T e cria query de T.class
		
		// define o from "NOME_DA_ENTIDADE", que retorna a raiz da consulta, como o alias v em from Venda v de um JPQL,
		// usado para acessar os valores
		Root<T> root = cq.from(type); 
		//por exemplo, valor = root.get("valor"); seria equivalente a um v.valor em JPQL
		cq.select(root); // monta uma consulta select all
		return this.entityManager.createQuery(cq).getResultList();
	}
	
	@Interceptors(InterceptorTransactional.class)
	public T insert(T t) {
		entityManager.persist(t);
		return t;
	}

	@Interceptors(InterceptorTransactional.class)
	public T update(T entidade) {
		entityManager.merge(entidade);
		return entidade;
	}
	
	@Interceptors(InterceptorTransactional.class)
	public void delete(T entidade) {
		entityManager.remove(entidade);
	}
}
