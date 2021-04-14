package br.com.fiap.tds.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.MotoristaDao;
import br.com.fiap.tds.entity.Motorista;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public class MotoristaDaoImpl<Entidade, Chave> extends GenericDaoImpl<Entidade, Chave>{
	
	private EntityManager em;
	

	public MotoristaDaoImpl(EntityManager em) {
		super(em);
	}
			

}
