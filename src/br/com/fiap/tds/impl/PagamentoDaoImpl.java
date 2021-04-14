package br.com.fiap.tds.impl;

import javax.persistence.EntityManager;

public class PagamentoDaoImpl<Entidade, Chave> extends GenericDaoImpl<Entidade, Chave> {
	
private EntityManager em;
	

	public PagamentoDaoImpl(EntityManager em) {
		super(em);
	}
			
}
