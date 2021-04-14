package br.com.fiap.tds.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<Entidade, Chave> implements GenericDao<Entidade, Chave> {
	
	private EntityManager em;
	
	private Class<Entidade> classe; //atributo que armazena o .class da Entidade
	
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<Entidade>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(Entidade entidade) {
		em.persist(entidade);
		
	}

	@Override
	public Entidade search(Chave id) throws EntityNotFoundException {
		Entidade entidade = em.find(classe, id);
		if(entidade == null) throw new EntityNotFoundException();
		return entidade;
	}

	@Override
	public void update(Entidade entidade) {
		em.merge(entidade);	
		
	}

	@Override
	public void delete(Chave id) throws EntityNotFoundException {
		Entidade entidade = search(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
		
			
	}
	


}
