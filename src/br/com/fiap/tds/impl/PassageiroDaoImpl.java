package br.com.fiap.tds.impl;

import javax.persistence.EntityManager;

public class PassageiroDaoImpl<Entidade, Chave> extends GenericDaoImpl<Entidade, Chave> {
	
	private EntityManager em;
	

	public PassageiroDaoImpl(EntityManager em) {
		super(em);
	}
}
