package com.stefanini.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;


public class EntityManagerProducer {

	@Produces
	@ApplicationScoped
	public EntityManagerFactory criaFactory() {
		return Persistence.createEntityManagerFactory("pessoas");
	}

	@Produces
	@RequestScoped
	public EntityManager criaEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	public void finaliza(@Disposes EntityManager manager) {
		manager.close();
	}
	
	
}
