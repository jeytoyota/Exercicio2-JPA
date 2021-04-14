package br.com.fiap.tds.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public class VeiculoDaoImpl extends GenericDaoImpl<Veiculo, Integer>{
	
	private EntityManager em;

	public VeiculoDaoImpl(EntityManager em) {
		super(em);
	}
	
	

}
