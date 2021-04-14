package br.com.fiap.tds.impl;

import javax.persistence.EntityManager;

public class CorridaDaoImpl<Entidade, Chave> extends GenericDaoImpl<Entidade, Chave> {
	
	private EntityManager em;
	
	public CorridaDaoImpl(EntityManager em) {
		super(em);
	}
}
